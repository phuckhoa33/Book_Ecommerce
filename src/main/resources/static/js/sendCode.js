// Get input form object
let otp_form_register = document.querySelector(".otp_code");
let password_form_register = document.querySelector('.passwordRegister');
let phoneLogin = document.querySelector('.emailLogin');
let passwordLogin = document.querySelector('.passwordLogin');
let form_login = document.querySelector(".form-login");
let otp_code = document.querySelector('.otp_code');    
let phoneRegister = document.querySelector('.emailRegister');
let register_form = document.querySelector('.register-form');

const myToast = document.querySelector('.alert_toast');
// Two variable about disabled in both above form
let sended_code = false;
let true_code = false;

function run_toast() {
    const myToast = new bootstrap.Toast(document.querySelector('.alert_toast'));
    myToast.show();
}
run_toast();

// Disabled or abled in both form
function execute_disable(){
    if(sended_code){
        otp_form_register.disabled = false;
    }
    else {
        otp_form_register.disabled = true;
    }

    if(true_code){
        password_form_register.disabled = false;
    }
    else {
        password_form_register.disabled = true;
    }
}

function changeContent(mess){
    let message = document.querySelector('.message');
    message.innerHTML = mess;
}

// Function about only approve number format in input form
function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
/*<![CDATA[*/
var serverCode = /*[[${code}]]*/ '';
function checkCoded(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    if(evt.target.value.length===6){
        true_code = true;
        password_form_register.classList.add("confirmed_background_register");
        execute_disable();  
    }
}

function post_method(respoint, data){

    fetch(respoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        // Handle the response
        if (response.ok) {
            // Request was successful
            execute_disable();
            changeContent('Successfully')
            run_toast();
            console.log('POST request successful');
        } else {
            // Request failed
            changeContent('Failed')
            run_toast();
            console.error('POST request failed');
        }
    })
    .catch(error => {
        // Handle any errors
        console.error(error);
    });
}

// Send code function in submit button
function sendCode(event){
    event.preventDefault(); 
    sended_code = true;
    
    var data = {
        // Your data to be sent in the request body
        key1: phoneRegister.value
    };
    post_method('/user/sendCode', data)
}
function register(event) {
    // Prevent the default form submission behavior
    event.preventDefault();

    // Check the length of the input field
    const inputLength = password_form_register.value.length;
    

    // If the length is 0, show the toast
    if (inputLength === 0) {
        run_toast()
    }
    else {
        register_form.submit();
    }
}

function login(event){
    event.preventDefault();

    // Check the length of the input field
    const phoneNumber = phoneLogin.value.length;
    const password = passwordLogin.value.length;
    console.log(phoneLogin, passwordLogin);

    // If the length is 0, show the toast
    if (phoneNumber<11 || password===0) {
        run_toast();
    }
    console.log("HELLO");
    form_login.submit();
}