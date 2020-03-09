function logout() {
    document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "userName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "mailid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "createDate=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "phone=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    window.location = "../home/index.html";
}

var baseUrl = 'http://ec2-18-221-71-220.us-east-2.compute.amazonaws.com';




function initia() {
    var getusername = getCookie('userName');
    document.getElementById('nameboard').innerHTML = `${getusername}`;

    var getemail = getCookie('mailid');

    const url = baseUrl + ':8080/api/logins/profile';
    const data = {
        'mailid': getemail
    };
    console.log('' + JSON.stringify(data));
    fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
            data.map(p => {

                document.getElementById('inputfirstname').defaultValue = p.firstName;
                document.getElementById('inputlastname').defaultValue = p.lastName;
                document.getElementById('dob').defaultValue = p.dob;
                document.getElementById('inputcompanyname').defaultValue = p.companyName;
                document.getElementById('inputaddress').defaultValue = p.address;
                document.getElementById('inputcity').defaultValue = p.city;
                document.getElementById('inputpin').defaultValue = p.pin;
                document.getElementById('pic').src = "https://www.searchpng.com/wp-content/uploads/2019/02/Men-Profile-Image-715x657.png";


                document.getElementById('inputfirstname').disabled = true;
                document.getElementById('inputlastname').disabled = true;
                document.getElementById('dob').disabled = true;
                document.getElementById('inputcompanyname').disabled = true;
                document.getElementById('inputaddress').disabled = true;
                document.getElementById('inputcity').disabled = true;
                document.getElementById('inputpin').disabled = true;
                document.getElementById('update').disabled = false;
                document.getElementById('save').disabled = true;


            });
        })
        .catch(error => console.error(error));
}


function modify() {
    document.getElementById('save').disabled = false;

    document.getElementById('inputfirstname').disabled = false;
    document.getElementById('inputlastname').disabled = false;
    document.getElementById('dob').disabled = false;
    document.getElementById('inputcompanyname').disabled = false;
    document.getElementById('inputaddress').disabled = false;
    document.getElementById('inputcity').disabled = false;
    document.getElementById('inputpin').disabled = false;
    document.getElementById('update').disabled = true;

}







function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}



function savefunction() {
    //alert("entered into save function");
    var getid = getCookie('id');
    var getusername = getCookie('userName');
    document.getElementById('nameboard').innerHTML = `${getusername}`;
    var getemail = getCookie('mailid');

    const url = baseUrl + ':8080/api/logins/profile';
    const data = {
        'mailid': getemail
    };
    console.log('' + JSON.stringify(data));
    fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
            data.map(p => {
                const password = p.password;
                const createdate = p.createDate;
                const phone = p.phone;
                var picurl = p.picurl;
                var role = p.role;



                const firstname = document.getElementById('inputfirstname').value;
                const lastname = document.getElementById('inputlastname').value;
                const d_o_b = document.getElementById('dob').value;
                const company = document.getElementById('inputcompanyname').value;
                const address = document.getElementById('inputaddress').value;
                const city = document.getElementById('inputcity').value;
                const pin = document.getElementById('inputpin').value;




                const url = baseUrl + ':8080/api/logins';
                const data = {
                    'id': getid,
                    'userName': getusername,
                    'mailid': getemail,
                    'password': password,
                    'createDate': createdate,
                    'phone': phone,
                    'firstName': firstname,
                    'lastName': lastname,
                    'dob': d_o_b,
                    'companyName': company,
                    'address': address,
                    'city': city,
                    'pin': pin,
                    'picurl': "none",
                    'role': role
                };
                document.cookie = "update=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;"
                console.log('' + JSON.stringify(data));
                fetch(url, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(data),
                    })
                    .then(response => {
                        // alert("updated");
                        initia();
                    })
                    .catch(error => console.error(error));
            });
        })
        .catch(error => console.error(error));
}







function postData(url = '', data = {}) {
    console.log('posting starts');
    return fetch(url, {
            method: 'POST',
            mode: 'cors',
            cache: 'no-cache',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json',
            },
            redirect: 'follow',
            referrer: 'no-refrrer',
            body: JSON.stringify(data),
        })
        .then(response => response.json());
}