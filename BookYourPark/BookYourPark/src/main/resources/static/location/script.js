function logout() {
    document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "userName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "mailid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "createDate=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "phone=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    window.location = "../home/index.html";
}


var locations = [];
var markers = [];

function loadlocation() {

    document.cookie = "location=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";

    fetch('http://localhost:8080/api/locations')
        .then((res) => res.json())
        .then(posts => {

            let output = '';
            var x = 0;

            posts.map(p => {


                document.getElementById('posts').innerHTML += `

                <tr onclick="locClick(${p.locId})">
                <td>${p.locName}</td>
                <td>${p.locAddress}</td>
                <td>${p.availableSlots}</td>
                </tr>
                `;

                locations[x] = new google.maps.LatLng({ lat: parseFloat(p.latitude), lng: parseFloat(p.longitude) });
                x = x + 1;

            });
        })
        .catch((err) => {
            console.log(err);
        });

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition); //position.coords.latitude, position.coords.longitude  variables for getting cooordinates

    } else {
        alert("geo location is not suported by your browser");
    }
}




function showPosition(position) {
    console.log(position.coords.latitude);
    console.log(position.coords.longitude);
    setTimeout(function() {
        initMaps(position.coords.latitude, position.coords.longitude);
    }, 3000);
}



function initMaps(latitude, longitude) {
    var newlatitude = latitude.toFixed(6);
    var newlongitude = longitude.toFixed(6);
    var mapProp = {
        center: new google.maps.LatLng(parseFloat(13.068509), parseFloat(80.220951)),
        zoom: 16,
    };
    var map = new google.maps.Map(document.getElementById("map"), mapProp);
    var marker = new google.maps.Marker({ position: new google.maps.LatLng(parseFloat(newlatitude), parseFloat(newlongitude)), map: map });
    console.log(locations.length);
    for (var i = 0; i < locations.length; i++) {
        console.log(locations[i]);
        markers.push(new google.maps.Marker({
            position: locations[i],
            map: map,
            animation: google.maps.Animation.DROP
        }));

    }
}


function clearMarkers() {
    for (var i = 0; i < locations.length; i++) {
        markers[i].setMap(null);
    }
    markers = [];
}



function sorttable() {

    var sort = document.getElementById('myList');
    var strSel = sort.options[sort.selectedIndex].value;

    if (strSel != "") {

        clearMarkers();
        for (var i = 0; i < locations.length; i++) {
            locations.pop();
        }


        let element = document.getElementById("posts");
        while (element.firstChild) {
            element.removeChild(element.firstChild);
        }
        const Data = {
            url: 'http://localhost:8080/api/locations/sort',
            data: {
                'locSector': strSel
            }
        };
        postData(Data.url, Data.data)
            .then(posts => {
                var x = 0;
                posts.map(p => {
                    console.log("entered");
                    document.getElementById('posts').innerHTML += `
                    
            <tr onclick="locClick(${p.locId})">
            <td>${p.locName}</td>
            <td>${p.locAddress}</td>
            <td>${p.availableSlots}</td>
            </tr>
            `;
                    locations[x] = new google.maps.LatLng({ lat: parseFloat(p.latitude), lng: parseFloat(p.longitude) });
                    x = x + 1;
                });
            })
            .catch((err) => {
                console.log(err);
            });
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition); //position.coords.latitude, position.coords.longitude  variables for getting cooordinates

        } else {
            alert("geo location is not suported by your browser");
        }


    } else {
        clearMarkers();
        let element = document.getElementById("posts");
        while (element.firstChild) {
            element.removeChild(element.firstChild);
        }
        loadlocation();
    }
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


function locClick(loc) {
    document.cookie = "location=" + loc + ";path=/";
    window.location = "../slot/index.html";
}