// Function to notify the user about the start date of a vacation
function notifyStartDate(startDate) {
    alert("Vacation Start Date: " + startDate);
}

document.addEventListener("DOMContentLoaded", function() {
    // Get all buttons with class 'notify-start-date'
    const buttons = document.querySelectorAll('.notify-start-date');

    // Loop through the buttons and add event listener to each
    buttons.forEach(button => {
        button.addEventListener('click', function() {
            // Get the start date from the data attribute
            const startDate = this.getAttribute('data-start-date');

            // Show the start date in a pop-up message
            if (startDate) {
                alert("The vacation starts on: " + startDate);
            } else {
                alert("Start date not available.");
            }
        });
    });
});

