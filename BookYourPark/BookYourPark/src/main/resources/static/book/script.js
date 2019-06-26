function initial(){
    slot=getCookie('slot');
    loc=getCookie('location');
    fetch('http://localhost:8080/api/locations/'+loc)
    .then((res)=>res.json())
    .then(posts=>{   
      

      document.getElementById('locname').innerHTML=posts.locName;
      document.getElementById('locaddress').innerHTML=posts.locAddress+","+posts.locCity;



      
    })
    .catch((err)=>{
        console.log(err);
    });


    fetch('http://localhost:8080/api/slotdetails/'+loc)
    .then((res)=>res.json())
    .then(posts=>{        
        
            document.getElementById('slotdetail').innerHTML=posts.name;
            document.getElementById('value').innerHTML=posts.value;      
        
    })
    .catch((err)=>{
        console.log(err);
    });




    var d = new Date();
    var n = d.toISOString().replace('Z', '');

    document.getElementById('fromTime').defaultValue=n;

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



