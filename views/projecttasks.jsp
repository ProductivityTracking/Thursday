<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project Tasks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        form {
            margin-bottom: 10px;
        }

        label {
            display: inline-block;
            width: 70px;
            font-weight: bold;
            margin-right: 5px;
        }

        select {
            width: 200px;
            padding: 5px;
            margin-right: 10px;
        }

        button {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <h1>Project Tasks</h1>

    <!-- Add button for adding a project task -->
    <form action="addProjectTaskForm" method="GET">
        <button type="submit">Add Project Task</button>
    </form>

    <!-- Add filters for project-wise and resource-wise views -->
    <form action="/projecttasks" method="get">
        <label for="projectId">Project:</label>
        <select name="projectId" id="projectId">
            <option value="">All</option>
            <!-- Populate project options -->
            <c:forEach items="${projects}" var="project">
                <option value="${project.projectId}">${project.projectName}</option>
            </c:forEach>
        </select>

        <label for="resourceId">Resource:</label>
        <select name="resourceId" id="resourceId">
            <option value="">All</option>
            <!-- Populate resource options -->
            <c:forEach items="${resources}" var="resource">
                <option value="${resource.userId}">${resource.userDisplayName}</option>
            </c:forEach>
        </select>

        <button type="submit">Apply Filters</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Task ID</th>
                <th>Task Name</th>
                <th>Task Description</th>
                <th>Task AssignedUserId</th>
                <th>Actions</th> <!-- Add column for actions -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${projectTasks}" var="task">
                <tr>
                    <td>${task.taskId}</td>
                    <td>${task.taskName}</td>
                    <td>${task.taskDescription}</td>
                    <td>${task.assignedUserId}</td>
                    <td>
                        <!-- Add button for viewing task details -->
                        <form action="taskdetails" method="get">
                            <input type="hidden" name="taskId" value="${task.taskId}" />
                            <button type="submit">View Details</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
