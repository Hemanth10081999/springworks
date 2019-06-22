function logout(){
    document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    window.location="../home/index.html";
}

function loadlocation(){
    fetch('http://localhost:8080/api/locations')
        .then((res)=>res.json()).then(posts=>{
            let output='';
            posts.map(p=>{
                document.getElementById('posts').innerHTML+=`

                <tr>
                <td>${p.locId}</td>
                <td>${p.locName}</td>
                <td>${p.locAddress}</td>
                <td>${p.totalSlots}</td>
                <td>${p.availableSlots}</td>
                </tr>
                
                
                `;
                console.log(p.title)
            });
        })
        .catch((err)=>{
            console.log(err);
        });
}