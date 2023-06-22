

<!DOCTYPE html>
<html>
<head>
  <title>Overall Project Analytics</title>
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
  <h1>Overall Project Analytics</h1>
	  <div class="chart-container" style="width: 40%;">
    <div class="chart">
      <h3 style="margin-bottom: 170px;">Project Overview - Stacked Bar Graph</h3>
      <canvas id="stackedBarChart"></canvas>
    </div>
    <div class="chart" style="width: 120%;">
      <h3>Project Metrics - Radar Chart</h3>
      <canvas id="radarChart"></canvas>
    </div>
  </div>

  <script>
    // Define the data for stacked bar graph (tasks and subtasks completed for each day - example data)
    var tasksCompletedData = [5, 3, 8, 2, 6, 4, 7, 9, 5, 3, 8, 2, 6, 4, 7, 9, 5, 3, 8, 2, 6, 4, 7, 9, 5, 3, 8, 2, 6, 4];
    var subtasksCompletedData = [3, 2, 6, 1, 4, 3, 5, 7, 3, 2, 6, 1, 4, 3, 5, 7, 3, 2, 6, 1, 4, 3, 5, 7, 3, 2, 6, 1, 4, 3];

    // Create the stacked bar graph
    var stackedBarCtx = document.getElementById('stackedBarChart').getContext('2d');
    var stackedBarChart = new Chart(stackedBarCtx, {
      type: 'bar',
      data: {
        labels: Array.from({length: 30}, (_, i) => i + 1),
        datasets: [
          {
            label: 'Tasks Completed',
            data: tasksCompletedData,
            backgroundColor: 'rgba(54, 162, 235, 0.5)',
            borderColor: 'rgba(54, 162, 235, 1)',
            borderWidth: 1.5
          },
          {
            label: 'Subtasks Completed',
            data: subtasksCompletedData,
            backgroundColor: 'rgba(255, 99, 132, 0.5)',
            borderColor: 'rgba(255, 99, 132, 1)',
            borderWidth: 1.5
          }
        ]
      },
      options: {
        scales: {
          x: {
            stacked: true
          },
          y: {
            stacked: true
          }
        }
      }
    });

    

    // Define the data for radar chart (example data)
    var numberOfResources = 5;
    var numberOfHoursWorked = 150;
    var completionOfTasks = 80;
    var completionOfSubtasks = 70;

    // Create the radar chart
    var radarCtx = document.getElementById('radarChart').getContext('2d');
    var radarChart = new Chart(radarCtx, {
      type: 'radar',
      data: {
        labels: ['Number of Resources', 'Number of Hours Worked', 'Completion of Tasks', 'Completion of Subtasks'],
        datasets: [{
          label: 'Metrics',
          data: [numberOfResources, numberOfHoursWorked, completionOfTasks, completionOfSubtasks],
          backgroundColor: 'rgba(54, 162, 235, 0.5)',
          borderColor: 'rgba(54, 162, 235, 1)',
          borderWidth: 1
        }]
      },
      options: {
        scale: {
          ticks: {
            beginAtZero: true
          },
          pointLabels: {
            fontColor: 'black',
            fontSize: 12
          }
        }
      }
    });
  </script>
</body>
<style>
.chart-container {
  display: flex;
}
.push{
martgin-bottom:200px;
}

.chart {
  flex: 1;
  padding: 20px;
}
.stackedBarChart {
margin-top:100px;
}

.chart canvas {
  width: 100%;
  height: 100%;
}
</style>
</html>