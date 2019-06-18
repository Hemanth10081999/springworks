alert('Hi there');

function loadPosts(){
    fetch('http://jsonplaceholder.typicode.com/posts')
        .then((res)=>res.json()).then(posts=>{
            let output = '';
            posts.map(p=>{
                document.getElementById('posts').innerHTML += `
                <tr>
                <td>${p.title}</td>
                <td>${p.body}</td>
                <td>50</td>
                </tr>

                `;
                console.log(p.title);
            });
        })
        .catch((err)=>{
            console.log('err');
        });
        
}