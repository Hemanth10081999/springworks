function logout(){
    document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    window.location="../home/index.html";
}

function loadlocation(){
    fetch('http://localhost:8080/api/locations')
        .then((res)=>res.json())
        .then(posts=>{
            let output='';
            var x=1;
            posts.map(p=>{

                
                document.getElementById('posts').innerHTML+=`

                <tr onclick="locClick(${p.locId})">
                <td>${x++}</td>
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


function sorttable(){
    
    var sort = document.getElementById('myList');
    var strSel = sort.options[sort.selectedIndex].value;
    console.log('entered into click');

    if(strSel!=""){
        document.getElementById('posts').innerHTML=``;
        const Data={
        url: 'http://localhost:8080/api/locations/sort',
        data: {
            'locSector':strSel
        }
    };
    postData(Data.url,Data.data)

    .then(posts=>{

        var x=1;

        posts.map(p=>{

            
            document.getElementById('posts').innerHTML+=`
            
            <tr onclick="locClick(${p.locId})">
            <td>${x++}</td>
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
    else{
        document.getElementById('posts').innerHTML=``;
        loadlocation();
    }
}



function postData(url='',data={}){
    console.log('posting starts');
    return fetch(url,{
        method:'POST',
        mode:'cors',
        cache: 'no-cache',
        credentials:'same-origin',
        headers:{
            'Content-Type':'application/json',
        },
        redirect:'follow',
        referrer: 'no-refrrer',
        body: JSON.stringify(data),
    })
    .then(response => response.json());
}


function locClick(loc){
    document.cookie="location="+loc+";path=/";
    window.location="../slot/index.html";
}