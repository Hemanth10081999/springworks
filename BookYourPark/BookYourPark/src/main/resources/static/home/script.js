function sendEmail() {
    console.log("email initiated");
    const email = document.getElementById('inputEmail').value;
    const query = document.getElementById('inputquery').value;
    console.log(email, query);
    Email.send({
        Host: "smtp.gmail.com",
        Username: "vhemantharajan@gmail.com",
        Password: "Hemanth*1999",
        To: 'vhemantharajan@gmail.com',
        From: "vhemantharajan@gmail.com",
        Subject: "query from".concat(email),
        Body: query,
    }).then(
        message => alert("mail sent successfully, We will respond soon")
    );
}