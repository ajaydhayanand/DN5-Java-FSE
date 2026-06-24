SET SERVEROUTPUT ON;

/*
Assumed tables:
1. Customers(CustomerID, Name, Age, Balance, IsVIP)
2. Loans(LoanID, CustomerID, InterestRate, DueDate)
*/

DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Age
        FROM Customers;
BEGIN
    FOR customer_record IN customer_cursor LOOP
        IF customer_record.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_record.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Discount applied for Customer ID: ' || customer_record.CustomerID);
        END IF;
    END LOOP;

    COMMIT;
END;
/

DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR customer_record IN customer_cursor LOOP
        IF customer_record.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_record.CustomerID;

            DBMS_OUTPUT.PUT_LINE('VIP status set for Customer ID: ' || customer_record.CustomerID);
        END IF;
    END LOOP;

    COMMIT;
END;
/

DECLARE
    CURSOR loan_cursor IS
        SELECT c.CustomerID, c.Name, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan_record IN loan_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' || loan_record.LoanID ||
            ' for Customer ' || loan_record.Name ||
            ' (Customer ID: ' || loan_record.CustomerID ||
            ') is due on ' || TO_CHAR(loan_record.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
