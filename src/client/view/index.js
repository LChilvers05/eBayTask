//page elements
const pickupField = document.getElementById("pickupField");
const deliveryField = document.getElementById("deliveryField");
const vehicleDropdown = document.getElementById("vehicles");
const checkButton = document.getElementById("checkButton");
const resultLabel = document.getElementById("resultLabel");

checkButton.addEventListener("click", checkPressed);
resultLabel.style.visibility = "hidden";


var manualCheck = false;
/**
 * Checks that text field values are of appropriate format
 * @returns true if there is an error with user input
 */
function validationChecks() {
    var flag = false;

    var p = pickupField.value, d = deliveryField.value;

    //check no special characters are in postcode
    var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;

    if (!(p != "" && (p.length >= 5 && p.length <= 8) && !format.test(p))) {
        flag = true;
        //to check if button was pushed instead of automatic update
        if (manualCheck) {
            //show error by turning red
            pickupField.style.backgroundColor = "#ffa8a8";
        }
    }
    if (!(d != "" && (d.length >= 5 && d.length <= 8) && !format.test(d))) {
        flag = true;
        if (manualCheck) {
            deliveryField.style.backgroundColor = "#ffa8a8";
        }
    }
    manualCheck = false;

    return flag;
}

function checkPressed() {
    manualCheck = true;
    getPrice();
}

function getPrice() {
    var inputError = validationChecks();
    if (!inputError) {
        pickupField.style.backgroundColor = "white";
        deliveryField.style.backgroundColor = "white";
        //clean input
        pickupField.value = pickupField.value.replace(/\s/g, '').toUpperCase();
        deliveryField.value = deliveryField.value.replace(/\s/g, '').toUpperCase();
        var vehicle = getVehicleString(vehicleDropdown.value);
        makeRequest(pickupField.value, deliveryField.value, vehicle);
    }
}

/**
 * Converts dropdown vehicle string to expected json key
 * @param {*} str vehicle string in dropdown menu
 * @returns json key for vehicle
 */
function getVehicleString(str) {
    var result;
    switch (str) {
        case "parcel car":
            result = "parcel_car";
            break;
        case "small van":
            result = "small_van";
            break;
        case "large van":
            result = "large_van";
            break;
        default:
            result = str;
            break;
    }
    return result;
}

/**
 * Display price result in required format
 * @param {*} price the price value returned from api
 * @param {*} error show error message instead if true
 */
function updateResult(price, error) {
    if (!error) {
        resultLabel.innerHTML = `A delivery from ${pickupField.value} to ${deliveryField.value} using a ${vehicleDropdown.value} will cost you £${price}`
    } else {
        resultLabel.innerHTML = "error"
    }
}

/**
 * Make the post request 
 * @param {*} pickupPostcode pickup_postcode key
 * @param {*} deliveryPostcode delivery_postcode key
 * @param {*} vehicle vehicle key
 */
function makeRequest(pickupPostcode, deliveryPostcode, vehicle) {
    resultLabel.style.visibility = "visible";
    resultLabel.innerHTML = "checking...";
    var http = new XMLHttpRequest();
    var url = "http://localhost:8080/quote";
    http.open("POST", url, true);
    http.setRequestHeader("Content-Type", "application/json");
    //update view
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            var json = JSON.parse(http.responseText);
            updateResult(json.price, false);
        } else {
            updateResult(null, true)
        }
    };
    //send body
    var data = JSON.stringify(
        {
            "pickup_postcode": pickupPostcode,
            "delivery_postcode": deliveryPostcode,
            "vehicle": vehicle
        }
    );
    http.send(data);
}