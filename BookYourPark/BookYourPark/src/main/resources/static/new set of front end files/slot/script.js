function logout(){
    document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "userName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "mailid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "createDate=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    document.cookie = "phone=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    window.location="../home/index.html";
}


function loadslot(){
    loc=getCookie('location');

    document.cookie = "slot=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";



    fetch('http://localhost:8080/api/locations/'+loc)
    .then((res)=>res.json())
    .then(posts=>{   
      

      document.getElementById('locname').innerHTML=posts.locName;
      document.getElementById('add').innerHTML=posts.locAddress;
      document.getElementById('city').innerHTML=posts.locCity+"-"+posts.locPin;
      document.getElementById('support').innerHTML=posts.locSupport;



      initMap(posts.latitude,posts.longitude);
    })
    .catch((err)=>{
        console.log(err);
    });











    
    fetch('http://localhost:8080/api/locations/'+loc)
    .then((res)=>res.json())
    .then(posts=>{


        
        let output='';
        var x=1;
        
        posts.slotdetails.forEach(p => {

          //alert(p.availability);
          if(p.availability==true){
                    
            document.getElementById('posts').innerHTML+=`

            <tr onclick="locClick(${p.id})">
            <td>${x++}</td>
            <td>${p.name}</td>
            <td>${p.floor}</td>
            <td>${p.time}</td>
            <td>${p.value}</td>
            </tr>
            `;
    
          }
        });
    })
    .catch((err)=>{
        console.log(err);
    });
}


function locClick(loc){
  document.cookie="slot="+loc+";path=/";
  window.location="../book/index.html";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i < ca.length; i++) {
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


  function initMap(latitude,longitude) 
  {
  var uluru = {lat: latitude, lng: longitude}; //should change depending on the location
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 17, center: uluru});
  var marker = new google.maps.Marker({position: uluru, map: map});
  }





  function sort(){
    var sort = document.getElementById('myList');
    var strSel = sort.options[sort.selectedIndex].value;
  
    let element = document.getElementById("posts");
    while (element.firstChild) {
      element.removeChild(element.firstChild);
    }

    fetch('http://localhost:8080/api/locations/'+loc)
    .then((res)=>res.json())
    .then(posts=>{
       var x=1;
        
        posts.slotdetails.forEach(p => {

          //alert(p.availability);
          if(p.availability==true){

            if(strSel==0){
              loadslot();
            }

            else if(p.type==strSel){
                    
            document.getElementById('posts').innerHTML+=`

            <tr onclick="locClick(${p.id})">
            <td>${x++}</td>
            <td>${p.name}</td>
            <td>${p.floor}</td>
            <td>${p.time}</td>
            <td>${p.value}</td>
            </tr>
            `;
            }
          }
        });
    })
    .catch((err)=>{
        console.log(err);
    });

  }