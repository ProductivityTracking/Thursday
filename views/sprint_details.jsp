<%@ page import="java.sql.*,com.nkxgen.spring.orm.model.SprintTasks,com.nkxgen.spring.orm.model.Sprint,java.util.List,java.util.ArrayList" %>
<%@ page import="com.nkxgen.spring.orm.model.ProjectDto" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sprint Details</title>
    <style>
    .back-btn {
        padding: 5px 10px;
        background-color: #f5f5f5;
        color: #333;
        text-decoration: none;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 12px;
        cursor: pointer;
    }
</style>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }

        h1, h2, h3 {
            color: #333333;
        }

        h1 {
            text-align: center;
        }

        h2 {
            margin-top: 20px;
        }

        p {
            margin: 10px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #cccccc;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        a.back-btn {
            display: block;
            margin-top: 20px;
            margin-bottom: 20px;
            text-align: center;
            text-decoration: none;
            color: #ffffff;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
        }

        a.back-btn:hover {
            background-color: #0056b3;
        }

        a.back-btn:active {
            background-color: #003d80;
        }
         tr#disp:hover {
        background-color: #f5f5f5;
        cursor: pointer;
    }
    </style>
</head>
<body>
    <h1>Sprint Details</h1>

    <%
    Sprint sprint = (Sprint)request.getAttribute("sprint");
    List<SprintTasks> sprintTasks = (List<SprintTasks>)request.getAttribute("tasksByIdSprints");  %>

            <h2>Sprint <%= sprint.getSprintId() %></h2>
            <p><strong>Start Date:</strong> <%= sprint.getStartDate() %></p>
            <p><strong>End Date:</strong> <%= sprint.getEndDate()  %></p>
            <p><strong>Module ID:</strong> <%= sprint.getModuleId().getId()  %></p>
            <p><strong>Project ID:</strong> <%= sprint.getProjectId().getProjectId()  %></p>
        <h3>Users and Tasks</h3>
        <table>
            <tr>
                <th>User ID</th>
                <th>Task ID</th>
            </tr>
        <% 
        for(SprintTasks stask : sprintTasks) {
        %>
		    <tr>
		        <td onclick="window.location.href='sprint_user_details?userid=<%= stask.getUserId() %>'"><%= stask.getUserId() %></td>
		        <td onclick="window.location.href='Taskdetails?mytaskid=<%= stask.getTaskId() %>'"><%= stask.getTaskId() %></td>
		    </tr>
        <% 
        }
%>
        </table>
    <button onclick="window.location.href='backlog'" class="back-btn">Back to PastDue</button>

</body>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
        }
        
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        .clickable-row {
            cursor: pointer;
        }
    </style>	
</html>
