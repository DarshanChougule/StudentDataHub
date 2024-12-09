<%-- 
    Document   : showdata
    Created on : 10-Oct-2024, 5:07:53 pm
    Author     : darsh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Student Data</title>
        <style>
            /* Theme-based styling */
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 20px;
                color: #333;
                position: relative;
            }

            h1 {
                text-align: center;
                color: #4CAF50;
                font-size: 22px;
                margin-bottom: 20px;
            }

            .container {
                max-width: 600px;
                margin: 0 auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                text-align: left;
            }

            .data-field {
                font-size: 18px;
                color: #555;
                margin: 15px 0;
            }

            .data-field span {
                font-weight: bold;
                color: #333;
            }

            /* Form button styling */
            .form-buttons {
                display: flex;
                justify-content: space-around;
                margin-top: 20px;
            }

            .form-buttons input {
                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 10px 20px;
                text-align: center;
                font-size: 16px;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                width: 45%;
            }

            .form-buttons input:hover {
                background-color: #45a049;
            }

            /* Back button styling */
            .back-button {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                width: 45%;
                text-align: center;
                display: inline-block;
            }

            .back-button:hover {
                background-color: #45a049;
            }

            /* Logout button styling */
            .logout-button {
                position: absolute;
                top: 20px;
                right: 20px;
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                font-size: 16px;
            }

            .logout-button:hover {
                background-color: #45a049;
            }

        </style>
    </head>
    <body>
        <!-- Logout Button in the top-right corner -->
        <a href="index.html" class="logout-button">Logout</a>

        <h1>Student Academic Data</h1>

        <div class="container">
            <div class="data-field">
                <span>Roll No.:</span> <%=request.getAttribute("roll")%>
            </div>
            <div class="data-field">
                <span>Marks of Operating System (OS):</span> <%=request.getAttribute("os")%>
            </div>
            <div class="data-field">
                <span>Marks of Database Engineering (DBE):</span> <%=request.getAttribute("db")%>
            </div>
            <div class="data-field">
                <span>Marks of Advanced Java:</span> <%=request.getAttribute("java")%>
            </div>
            <div class="data-field">
                <span>Marks of System Programming (SP):</span> <%=request.getAttribute("sp")%>
            </div>
            <div class="data-field">
                <span>Notes:</span> <%=request.getAttribute("notes")%>
            </div>
        </div>

        <!-- Form for Delete and Back actions -->
        <form action="deletedata" method="POST">
            <div class="form-buttons">
                <input type="hidden" name="roll" value="<%=request.getAttribute("roll")%>">
                <input type="submit" name="action" value="Delete">
                <a href="decision.html" class="back-button">Back</a>
            </div>
        </form>

    </body>
</html>
