let addUser = "/addresBook/addUser"
let person

async function postData(url, data = person) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *client
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    return await response.json(); // parses JSON response into native JavaScript objects
}

document.querySelector("button").onclick = () => {
    let fio = document.getElementsByClassName("fio")[0]
    let number = document.getElementsByClassName("number")[0]
    let email = document.getElementsByClassName("email")[0]
    let link = document.getElementsByClassName("link")[0]
    let notes = document.getElementsByClassName("notes")[0]
    person = {
        fio: fio,
        number: number,
        email: email,
        link: link,
        notes: notes
    }
    postData('http://localhost:8080' + addUser, person)
        .then((data) => {
            console.log(data); // JSON data parsed by `response.json()` call
        });
}

