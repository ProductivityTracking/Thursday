
<!DOCTYPE html>
<html>
<head>
  <title>Charts</title>
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <style>
    .chart-container {
      width: 50%;

    }


  </style>
</head>
<body>
<input type="number" id="numberInput" placeholder="Enter a number">
  <button onclick="showNextNumber()">Show</button>
  <div class="chart-container">
    <h3 style="margin-bottom: 0;">Tasks and subtasks done by resource id - Stacked Bar Graph</h3>
    <canvas id="stackedBarChart"></canvas>
  </div>
 <h3 style="margin-bottom: 0;">Hours Worked By Each Person - Histogram</h3>
  <div class="chart-container">
    <canvas id="histogramChart"></canvas>
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

    // Define an array of hours worked for 30 days (example data)
    var hoursWorked = [6, 7, 8, 5, 9, 6, 7, 8, 6, 8, 9, 6, 7, 6, 8, 7, 9, 5, 8, 7, 6, 8, 7, 6, 7, 8, 6, 9, 5, 7];

    // Create a histogram chart
    var histogramCtx = document.getElementById('histogramChart').getContext('2d');
    var histogramChart = new Chart(histogramCtx, {
      type: 'bar',
      data: {
        labels: Array.from({ length: hoursWorked.length }, (_, i) => (i + 1).toString()), // Generate labels 1-30
        datasets: [{
          label: 'Hours Worked',
          data: hoursWorked,
          backgroundColor: 'rgba(54, 162, 235, 0.5)',
          borderColor: 'rgba(54, 162, 235, 1)',
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
            title: {
              display: true,
              text: 'Number of Hours'
            }
          },
          x: {
            title: {
              display: true,
              text: 'Days'
            }
          }
        }
      }
    });
  </script>
</body>
</html>
