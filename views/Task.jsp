<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.nkxgen.spring.orm.model.FunctionalTask" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            box-sizing: border-box;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="datetime-local"],
        select,
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        textarea {
            height: 100px;
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        @media (max-width: 600px) {
            .container {
                max-width: 100%;
                padding: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Task Form</h2>
        <form action="TaskAdded" method="post">
            <% FunctionalTask ft = (FunctionalTask) request.getAttribute("funtask"); %>
            <input type="hidden" id="modlId" name="modlId" value="<%= ft != null ? ft.getModlId() : "" %>">
            <input type="hidden" id="funcId" name="funcId" value="<%= ft != null ? ft.getFuncId() : "" %>">
            <input type="hidden" id="desc" name="desc" value="<%= ft != null ? ft.getDesc() : "" %>">
            <input type="hidden" id="projId" name="projId" value="<%= ft != null ? ft.getProjId() : "" %>">
            
            <label for="taskName">Task Name:</label>
            <input type="text" id="taskName" name="taskName" required>

            <label for="taskCreationDateTime">Creation Date and Time:</label>
            <input type="datetime-local" id="taskCreationDateTime" name="taskCreationDateTime" required>

            <label for="taskType">Task Type:</label>
            <input type="text" id="taskType" name="taskType" required>

            <label for="referencedTask">Referenced Task ID:</label>
            <input type="text" id="referencedTask" name="referencedTask">

            <label for="taskCategory">Task Category:</label>
            <input type="text" id="taskCategory" name="taskCategory">

            <label for="taskCreator">Task Creator:</label>
            <input type="text" id="taskCreator" name="taskCreator" required>

            <label for="numberOfHoursRequired">Number of Hours Required:</label>
            <input type="text" id="numberOfHoursRequired" name="numberOfHoursRequired" required>

            <label for="taskExpectedDateTime">Expected Completion Date and Time:</label>
            <input type="datetime-local" id="taskExpectedDateTime" name="taskExpectedDateTime">

            <label for="taskCompletedDateTime">Actual Completion Date and Time:</label>
            <input type="datetime-local" id="taskCompletedDateTime" name="taskCompletedDateTime">

            <label for="taskSupervisor">Task Supervisor:</label>
            <input type="text" id="taskSupervisor" name="taskSupervisor">

            <label for="taskRemarks">Task Remarks:</label>
            <input type="text" id="taskRemarks" name="taskRemarks">

            <label for="taskStatus">Task Status:</label>
            <input type="text" id="taskStatus" name="taskStatus" required>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
