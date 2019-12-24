function logout() {
    document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "userName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "mailid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "createDate=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "phone=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    window.location = "../home/index.html";
}





function loadlocation() {

    //get user location for map data
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition); //position.coords.latitude, position.coords.longitude  variables for getting cooordinates

    } else {
        alert("geo location is not suported by your browser");
    }




    document.cookie = "location=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";

    fetch('http://localhost:8080/api/locations')
        .then((res) => res.json())
        .then(posts => {

            let output = '';
            var x = 1;

            posts.map(p => {


                document.getElementById('posts').innerHTML += `

                <tr onclick="locClick(${p.locId})">
                <td>${p.locName}</td>
                <td>${p.locAddress}</td>
                <td>${p.availableSlots}</td>
                </tr>
                
                
                `;
                console.log(p.title)
            });
        })
        .catch((err) => {
            console.log(err);
        });
}


function showPosition(position) {
    console.log(position.coords.latitude);
    console.log(position.coords.longitude);
    initMaps(position.coords.latitude, position.coords.longitude);

}



function initMaps(latitude, longitude) {

    var newlatitude = latitude.toFixed(6);
    var newlongitude = longitude.toFixed(6);


    var mapProp = {
        center: new google.maps.LatLng(parseFloat(newlatitude), parseFloat(newlongitude)),
        zoom: 17,
    };
    var map = new google.maps.Map(document.getElementById("map"), mapProp);
    var marker = new google.maps.Marker({ position: new google.maps.LatLng(parseFloat(newlatitude), parseFloat(newlongitude)), map: map });


}


function sorttable() {

    var sort = document.getElementById('myList');
    var strSel = sort.options[sort.selectedIndex].value;

    if (strSel != "") {

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

                posts.map(p => {
                    console.log("entered");
                    document.getElementById('posts').innerHTML += `
            
            <tr onclick="locClick(${p.locId})">
            <td>${p.locName}</td>
            <td>${p.locAddress}</td>
            <td>${p.availableSlots}</td>
            </tr>
            `;
                    console.log(p.title)
                });
            })
            .catch((err) => {
                console.log(err);
            });
    } else {


        let element = document.getElementById("posts");
        while (element.firstChild) {
            element.removeChild(element.firstChild);
        }


        document.cookie = "location=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";

        fetch('http://localhost:8080/api/locations')
            .then((res) => res.json())
            .then(posts => {

                let output = '';
                var x = 1;

                posts.map(p => {


                    document.getElementById('posts').innerHTML += `
    
                    <tr onclick="locClick(${p.locId})">
                    <td>${p.locName}</td>
                    <td>${p.locAddress}</td>
                    <td>${p.availableSlots}</td>
                    </tr>
                    
                    
                    `;
                    console.log(p.title)
                });
            })
            .catch((err) => {
                console.log(err);
            });
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