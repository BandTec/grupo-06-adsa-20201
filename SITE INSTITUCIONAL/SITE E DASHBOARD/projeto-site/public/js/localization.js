//luz
var Latitude;
var longitude;


function getLocationLuz() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPositionLuz);

    } else {
        alert("O seu navegador não suporta Geolocalização.");
    }
}

function showPositionLuz(position) {
    Latitude = position.coords.latitude
    longitude = position.coords.longitude;
    var link = "https://www.google.com/maps/dir/" + Latitude + "," + longitude + "/Esta%C3%A7%C3%A3o+da+Luz+-+Pra%C3%A7a+da+Luz,+1,+Luz,+S%C3%A3o+Paulo+-+SP/@-23.3969312,-46.8795549,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x94ce58593946291b:0x831e609593a69549!2m2!1d-46.6353093!2d-23.5350794!3e0";
    window.location.href = link;

}

// mackenzie



function getLocationmackenzie() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPositionmackenzie);

    } else {
        alert("O seu navegador não suporta Geolocalização.");
    }
}

function showPositionmackenzie(position) {
    Latitude = position.coords.latitude
    longitude = position.coords.longitude;
    var link = "https://www.google.com/maps/dir/" + Latitude + "," + longitude + "/Higienópolis-Mackenzie+-+R.+da+Consolação+-+Consolação,+São+Paulo+-+SP,+01220-010/@-23.4047484,-46.8377586,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x94ce58360d7a0d21:0xbaf1bdd653ff5b8d!2m2!1d-46.6522331!2d-23.5489657!3e3";
    window.location.href = link;

}
// paulista

function getLocationPaulista() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPositionPaulista);

    } else {
        alert("O seu navegador não suporta Geolocalização.");
    }
}

function showPositionPaulista(position) {
    Latitude = position.coords.latitude
    longitude = position.coords.longitude;
    var link = "https://www.google.com/maps/dir/" + Latitude + "," + longitude + "/Estação+Paulista+do+Metro+-+Consolação,+São+Paulo+-+SP,+01301-100/@-23.4075769,-46.8377586,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x94ce582da261e6b1:0x5ceb2e6bcbc1483b!2m2!1d-46.6620388!2d-23.5552763!3e3";
    window.location.href = link;

}

// pinheiros
function getLocationPinheiros() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPositionPinheiros);

    } else {
        alert("O seu navegador não suporta Geolocalização.");
    }
}

function showPositionPinheiros(position) {
    Latitude = position.coords.latitude
    longitude = position.coords.longitude;
    var link = "https://www.google.com/maps/dir/" + Latitude + "," + longitude + "/Pinheiros+-+R.+Capri,+145+-+Pinheiros,+São+Paulo+-+SP,+05425-030/@-23.4132312,-46.8381907,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x94ce57aec87cacc5:0x74c5d56ad34f1323!2m2!1d-46.7018831!2d-23.5673102!3e3";
    window.location.href = link;

}

// republica
function getLocationrepublica() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPositionrepublica);

    } else {
        alert("O seu navegador não suporta Geolocalização.");
    }
}

function showPositionrepublica(position) {
    Latitude = position.coords.latitude
    longitude = position.coords.longitude;
    var link = "https://www.google.com/maps/dir/" + Latitude + "," + longitude + "/República+-+Praça+da+República,+299+-+República,+São+Paulo+-+SP,+01045-001/@-23.4013994,-46.8389201,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x94ce584fa774cf9f:0x45c1692e29175d5c!2m2!1d-46.6423795!2d-23.5440158!3e0";
    window.location.href = link;

}

//butanta

function getLocationbutanta() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPositionbutanta);

    } else {
        alert("O seu navegador não suporta Geolocalização.");
    }
}

function showPositionbutanta(position) {
    Latitude = position.coords.latitude
    longitude = position.coords.longitude;
    var link = "https://www.google.com/maps/dir/" + Latitude + "," + longitude + "/Butantã,+São+Paulo+-+SP,+05503-001/@-23.4155661,-46.8377547,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x94ce57aad7a3540d:0x789bc44e1079b1b3!2m2!1d-46.7080885!2d-23.5718263!3e3";
    window.location.href = link;

}