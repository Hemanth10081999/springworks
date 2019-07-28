function logout() {
    document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "userName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "mailid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "createDate=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "phone=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    window.location = "../home/index.html";
}




function initial() {
    let element = document.getElementById("posts");
    while (element.firstChild) {
        element.removeChild(element.firstChild);
    }


    var getid = getCookie('id');


    fetch('http://localhost:8080/api/vehicles/login/' + getid)

    .then((response) => response.json())
        .then(posts => {

            var x = 1;

            posts.map(p => {

                document.getElementById('posts').innerHTML += `

            <tr>
            <td>${x++}</td>
            <td>${p.number}</td>
            <td>${p.name}</td>
            <td>${p.type}</td>
            </tr>
            
            
            `;
                console.log(posts.title)
            })
        })
        .catch((err) => {
            console.log(err);
        });
}










function add() {
    var getid = getCookie('id');

    const name = document.getElementById('vehiclename').value;
    const number = document.getElementById('vehiclenumber').value;
    const color = document.getElementById('inputcolor').value;
    var sort = document.getElementById('myList');
    var strSel = sort.options[sort.selectedIndex].value;




    const Data = {
        url: 'http://localhost:8080/api/vehicles',
        data: {
            "colour": color,
            "name": name,
            "number": number,
            "type": strSel,
            "login": getid
        }
    };

    postData(Data.url, Data.data)

    .then(data => {
        initial();
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