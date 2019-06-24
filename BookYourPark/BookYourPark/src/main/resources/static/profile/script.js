function initial(){
    console.log('searching already existing data');

    var username = getCookie("username");
    const Data={
        url: 'http://localhost:8080/api/logins/profile',
        data: {
            'mailid':username
        }
    };
    postData(Data.url,Data.data)

    .then(posts=>{
        posts.map(p=>{
            document.getElementById('nameboard').innerHTML+=`
                <h4>${p.userName}</h4>
            `;
            console.log(p.title)
        });
    })
    .catch((err)=>{
        console.log(err);
    });

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