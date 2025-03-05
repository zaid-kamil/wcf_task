// Function to update date and time
function updateDateTime() {
    const now = new Date();
    const options = {
        weekday: 'long',
        year: 'numeric',
        month: 'long',
        day: 'numeric',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit'
    };
    document.getElementById('datetime').textContent = now.toLocaleDateString('en-US', options);
}

// Update date and time every second
updateDateTime();
setInterval(updateDateTime, 1000);

// Set timer for 3 minutes
let formTimer = setTimeout(function () {
    alert("3 minutes have passed! Please complete your form submission.");
}, 3 * 60 * 1000);

// Function to validate form
function validateForm() {
    let isValid = true;

    // Clear previous error messages
    const errorElements = document.getElementsByClassName('error');
    for (let i = 0; i < errorElements.length; i++) {
        errorElements[i].textContent = '';
    }

    // Validate First Name
    const firstName = document.getElementById('firstName').value.trim();
    if (firstName === '') {
        document.getElementById('firstNameError').textContent = 'First Name must be entered';
        isValid = false;
    } else if (!/^[A-Za-z]+$/.test(firstName)) {
        document.getElementById('firstNameError').textContent = 'First Name must contain only characters';
        isValid = false;
    }

    // Validate Last Name
    const lastName = document.getElementById('lastName').value.trim();
    if (lastName === '') {
        document.getElementById('lastNameError').textContent = 'Last Name must be entered';
        isValid = false;
    } else if (!/^[A-Za-z]+$/.test(lastName)) {
        document.getElementById('lastNameError').textContent = 'Last Name must contain only characters';
        isValid = false;
    }

    // Validate Password
    const password = document.getElementById('password').value;
    if (password === '') {
        document.getElementById('passwordError').textContent = 'Password must be entered';
        isValid = false;
    } else if (password.length < 6 || password.length > 20) {
        document.getElementById('passwordError').textContent = 'Password length should be between 6 to 20 characters';
        isValid = false;
    }

    // Validate Confirm Password
    const confirmPassword = document.getElementById('confirmPassword').value;
    if (confirmPassword === '') {
        document.getElementById('confirmPasswordError').textContent = 'Confirm Password must be entered';
        isValid = false;
    } else if (confirmPassword.length < 6 || confirmPassword.length > 20) {
        document.getElementById('confirmPasswordError').textContent = 'Password length should be between 6 to 20 characters';
        isValid = false;
    } else if (password !== confirmPassword) {
        document.getElementById('confirmPasswordError').textContent = 'Passwords do not match';
        isValid = false;
    }

    // Validate Gender
    const genderOptions = document.querySelectorAll('input[name="gender"]');
    let genderSelected = false;
    for (let i = 0; i < genderOptions.length; i++) {
        if (genderOptions[i].checked) {
            genderSelected = true;
            break;
        }
    }
    if (!genderSelected) {
        document.getElementById('genderError').textContent = 'Gender must be selected';
        isValid = false;
    }

    // Validate Mobile Number
    const mobile = document.getElementById('mobile').value.trim();
    const mobilePattern = /^(\d{3}[-.\s]?\d{3}[-.\s]?\d{4})$/;
    if (mobile === '') {
        document.getElementById('mobileError').textContent = 'Mobile Number must be entered';
        isValid = false;
    } else if (!mobilePattern.test(mobile)) {
        document.getElementById('mobileError').textContent = 'Mobile Number must be in the format XXX-XXX-XXXX or XXX.XXX.XXXX or XXX XXX XXXX';
        isValid = false;
    }

    // Validate Date of Birth
    const dob = document.getElementById('dob').value.trim();
    const dobPattern = /^(\d{2})-(\d{2})-(\d{4})$/;
    if (dob === '') {
        document.getElementById('dobError').textContent = 'Date of Birth must be entered';
        isValid = false;
    } else if (!dobPattern.test(dob)) {
        document.getElementById('dobError').textContent = 'Date of Birth must be in the format DD-MM-YYYY';
        isValid = false;
    } else {
        // Additional validation to check if date is valid
        const parts = dob.split('-');
        const day = parseInt(parts[0], 10);
        const month = parseInt(parts[1], 10);
        const year = parseInt(parts[2], 10);

        const date = new Date(year, month - 1, day);

        if (date.getFullYear() !== year || date.getMonth() !== month - 1 || date.getDate() !== day) {
            document.getElementById('dobError').textContent = 'Please enter a valid date';
            isValid = false;
        }
    }

    // Validate Email
    const email = document.getElementById('email').value.trim();
    const emailPattern = /^[^\s@][^\s@]*@[^\s@]+\.[^\s@]+$/;
    if (email === '') {
        document.getElementById('emailError').textContent = 'Email Address must be entered';
        isValid = false;
    } else if (!emailPattern.test(email)) {
        document.getElementById('emailError').textContent = 'Please enter a valid email address';
        isValid = false;
    }

    // If form is valid, clear the timer
    if (isValid) {
        clearTimeout(formTimer);
    }

    return isValid;
}

// Reset timer when form is reset
document.getElementById('registrationForm').addEventListener('reset', function () {
    clearTimeout(formTimer);
    formTimer = setTimeout(function () {
        alert("3 minutes have passed! Please complete your form submission.");
    }, 3 * 60 * 1000);
});