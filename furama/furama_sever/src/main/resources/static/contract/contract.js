
function addNewAttachFacility() {

    // alert("world");
    $.ajax({
        url: "/api/attachFacility/getAll",
        type: "get",
        contentType: "application/json",
        dataType: 'json',
        success: function (data) {
            console.log(data)
           let table =    ` <table border='1' class='table table-dark'>
                            <tr>
                                <td>Ten</td>
                                <td>Gia</td>
                                <td>Don Vi</td>
                                <td>Tinh Trang</td>
                                <td>So Luong</td>
                            </tr>   `
            for (let i = 0; i < data.length ; i++) {
                   "</td>"+ "</tr>"
                table += "<tr> <td>" + data[i].name + "</td> " +
                    " <td>" + data[i].price + "</td> " +
                    " <td>" + data[i].unit + "</td>" +
                    " <td>" + data[i].status + "</td> " +
                    "<td>" +
                    `<input type="number" onchange="calculatePrice(this.value,${data[i].id})">`

            }
            table += "</table>"
            document.getElementById("attachFacility").innerHTML = table;

        }
    })
}
function deleteAttachFacility() {
    document.getElementById("attachFacility").innerHTML = "";
}

var checkNumber = new Map();
function calculatePrice(a,id) {
    let total =  document.getElementById("total");
    if(a > 0) {
        checkNumber.set(id,a)
        fetch("http://localhost:8081/api/attachFacility/findById/" + id)
            .then(reponse => reponse.json())
            .then(function (data) {
                total.innerText = parseInt(total.textContent) + a * data;
            })
    } else {
        let size =  checkNumber.get(id)
        checkNumber.delete(id)
        fetch("http://localhost:8081/api/attachFacility/findById/" + id)
            .then(reponse => reponse.json())
            .then(function (data) {
                total.innerText = parseInt(total.textContent) - size * data;
            })
    }




};
function facilitySelect() {
    let total =  document.getElementById("total");
    let a = document.getElementById("facility").value;
    fetch("http://localhost:8081/api/facility/findById/" + a)
        .then(reponse => reponse.json())
        .then(function (data) {
            // alert(data.cost);
            total.innerText  = data.cost;
        })
};

function saveContract() {
    console.log(checkNumber);
    let contractObject = {
        idService: document.getElementById("facility").value,
        idCustomer: document.getElementById("customer").value,
        dateStart:  document.getElementById("dateStart").value,
        dateFinish:  document.getElementById("dateFinish").value,
        deposit:  document.getElementById("deposit").value,
        rentingCost:  document.getElementById("total").textContent,
    };
    console.log(contractObject)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(contractObject),
        url: "/api/contractList/save",
        success: function (result) {

            checkNumber.forEach(((key, value) => {
                let attachFacility = {
                    idContract: result,
                    idAttachFacility: value,
                    quality: key
                }
                console.log(attachFacility)
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    data: JSON.stringify(attachFacility),
                    url: "/api/contractDetail/save",
                    success: function (result2) {

                    },
                    error: function (event2) {

                    }

                })
            }))

        },
        error: function (event) {

        }

    })
}
function detailAttachService(idContract) {
    fetch("http://localhost:8081/api/contractDetail/find/" + idContract)
        .then(reponse => reponse.json())
        .then(function (data) {
           data[0].id
        })
}