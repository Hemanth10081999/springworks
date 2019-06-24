



function handleClick(){
    console.log('hello');
    const name=document.getElementById('inputName').value;
    const email=document.getElementById('inputEmail').value;
    const phone=document.getElementById('inputPhone').value;
    const password=document.getElementById('inputPassword').value;
    const repassword=document.getElementById('rePassword').value;
    const url='http://localhost:8080/api/logins';

    var today=new Date();
    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds()+".000";
    var dateTime = date+'-'+time;



    if(name.length<3 || name.length>20){
        console.log("user name should be with in 4 to 20 characters")
        alert("user name should be with in 4 to 20 characters");
    }
    else{

        if(password!=repassword){
            console.log('pasword mismatch');
            alert("password mismatch");
        
        }

        else{
            var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
            if(password.match(decimal)){
                const data={
                    'userName': name,
                    'mailid': email,
                    'phone': phone,
                    'password': password,
                    'createDate':dateTime
                };
    
                console.log(''+JSON.stringify(data));
                fetch(url,{
                    method: 'POST',
                    headers: {
                        'Content-Type':'application/json',
                    },
                    body: JSON.stringify(data),
                })
                    .then(response => response.json())
                    .then(data => console.log(JSON.stringify(data)))
                    .then(response => {
                    


                        console.log('entered into click');

                        const Data={
                            url: 'http://localhost:8080/api/logins/login',
                            data: {
                                'mailid':email,
                                'password':password
                            }
                        };
                    
                        postData(Data.url,Data.data)
                        .then(data=>{
                            if((JSON.stringify(data))!= null)
                            {
                                document.cookie = "id="+data.id+";path=/";
                                document.cookie="userName="+data.userName+";path=/";
                                document.cookie="mailid="+data.mailid+";path=/";
                                document.cookie="password="+data.password+";path=/";
                                document.cookie="createDate="+data.createDate+";path=/";
                                document.cookie="phone="+data.phone+";path=/";
                                window.location="../location/index.html";
                            }
                            else{
                                alert("Bad login credentials")
                            }
                        })
                        .catch(error=>console.error(error));




                        window.location="../location/index.html";
                    })
                    .catch(error => console.error(error))


                    
            }
            else{
                console.log('Password must contain 8 to 15 characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character');
                alert("password must contain 8 to 15 characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character");
                
            }
        }
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

function loginClick(){
    console.log('entered into click');
    const email=document.getElementById('logEmail').value;
    const password=document.getElementById('logPassword').value;

    const Data={
        url: 'http://localhost:8080/api/logins/login',
        data: {
            'mailid':email,
            'password':password
        }
    };

    postData(Data.url,Data.data)
    .then(data=>{
        if((JSON.stringify(data))!= null)
        {
            if ((document.getElementById("check").checked) == true){
                var d = new Date();
                d.setTime(d.getTime() + (30*24*60*60*1000));
                var expires = "expires="+ d.toUTCString();
                
                
                document.cookie = "id="+data.id+";"+expires+";path=/";
                document.cookie="userName="+data.userName+";"+expires+";path=/";
                document.cookie="mailid="+data.mailid+";"+expires+";path=/";
                document.cookie="password="+data.password+";"+expires+";path=/";
                document.cookie="createDate="+data.createDate+";"+expires+";path=/";
                document.cookie="phone="+data.phone+";"+expires+";path=/";
                window.location="../location/index.html";
            }
            else{
                document.cookie = "id="+data.id+";path=/";
                document.cookie="userName="+data.userName+";path=/";
                document.cookie="mailid="+data.mailid+";path=/";
                document.cookie="password="+data.password+";path=/";
                document.cookie="createDate="+data.createDate+";path=/";
                document.cookie="phone="+data.phone+";path=/";
                window.location="../location/index.html";
            }
            
        }
        else{
            alert("Bad login credentials")
        }
        
    })
    .catch(error=>console.error(error));
}





function findcookie(){
    var username = getCookie("id");
    if (username != "") {
     window.location="../location/index.html";
    }
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


function checklogmail(){
    console.log("entered into check mail");
    var decimal=  /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    const element=document.getElementById('logEmail');
    const email=element.value;
    if(email.match(decimal)){
        console.log("match");
        document.getElementById('alertemail').innerHTML=``;
        document.getElementById('logbutton').disabled = false;
    }
    else{
        console.log("notmatch");
        document.getElementById('alertemail').innerHTML=`enter valid email`;
        document.getElementById('logbutton').disabled = true;
    }
}

function checkregmail(){
    console.log("entered into check mail");
    var decimal=  /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    const element=document.getElementById('inputEmail');
    const email=element.value;
    if(email.match(decimal)){
        console.log("match");
        document.getElementById('alertregmail').innerHTML=``;
        document.getElementById('sign').disabled = false;
    }
    else{
        console.log("notmatch");
        document.getElementById('alertregmail').innerHTML=`enter valid email`;
        document.getElementById('sign').disabled = true;
    }
}


function checkregname(){
    console.log("entered into check name");
    var decimal=  /^[a-z0-9_-]{3,15}$/;
    const element=document.getElementById('inputName');
    const email=element.value;
    if(email.match(decimal)){
        console.log("match");
        document.getElementById('alertregname').innerHTML=``;
        document.getElementById('sign').disabled = false;
    }
    else{
        console.log("notmatch");
        document.getElementById('alertregname').innerHTML=`Username must be lowercase and have atleast 3 letters`;
        document.getElementById('sign').disabled = true;
    }
}

function checkregphone(){
    console.log("entered into check name");
    var decimal=  /^[2-9]{2}[0-9]{8}$/;
    const element=document.getElementById('inputPhone');
    const email=element.value;
    if(email.match(decimal)){
        console.log("match");
        document.getElementById('alertregphone').innerHTML=``;
        document.getElementById('sign').disabled = false;
    }
    else{
        console.log("notmatch");
        document.getElementById('alertregphone').innerHTML=`10 digit mobile number need to be entered`;
        document.getElementById('sign').disabled = true;
    }
}

function checkregpass(){
    console.log("entered into check name");
    var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    const element=document.getElementById('inputPassword');
    const email=element.value;
    if(email.match(decimal)){
        console.log("match");
        document.getElementById('alertregpass').innerHTML=``;
        document.getElementById('sign').disabled = false;
    }
    else{
        console.log("notmatch");
        document.getElementById('alertregpass').innerHTML=`Password must have one uppercase, one number and one special character`;
        document.getElementById('sign').disabled = true;
    }
}

function checkregconf(){
    console.log("entered into check name");
    const confirm=document.getElementById('inputPassword');
    const conf=confirm.value;
    const element=document.getElementById('rePassword');
    const email=element.value;
    if(email==conf){
        console.log("match");
        document.getElementById('alertregconf').innerHTML=``;
        document.getElementById('sign').disabled = false;
    }
    else{
        console.log("notmatch");
        document.getElementById('alertregconf').innerHTML=`Password not maching`;
        document.getElementById('sign').disabled = true;
    }
}