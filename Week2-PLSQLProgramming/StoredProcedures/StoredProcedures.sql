SET SERVEROUTPUT ON;

/*
Assumed tables:
1. Accounts(AccountID, CustomerID, AccountType, Balance)
2. Employees(EmployeeID, Name, Department, Salary)
*/

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'SAVINGS';

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE Department = p_department;

    DBMS_OUTPUT.PUT_LINE('Bonus updated for department: ' || p_department);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_source_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;

    IF v_source_balance >= p_amount THEN
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account_id;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account_id;

        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully from Account '
            || p_from_account_id || ' to Account ' || p_to_account_id);
        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance in source account.');
    END IF;
END;
/

BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('IT', 10);
    TransferFunds(101, 102, 5000);
END;
/
