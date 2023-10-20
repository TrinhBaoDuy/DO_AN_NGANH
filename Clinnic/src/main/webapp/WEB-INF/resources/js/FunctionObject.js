function delObject(path, id) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Xóa không thành công!!!");
        });
    }
}

function checkusernameforadd(path, username) {
    fetch(`${path}/${username}`, {
        method: "GET"
    })
            .then(res => res.json())
            .then(data => {
                if (data === false) {
                    alert("Tên tài khoản đã tồn tại");
                } else{
                     alert("Tên tài khoản hợp lệ");
                }
            })
            .catch(error => {
                console.error(error);
            });
}

function checkusernameforupdate(path, username, id) {
    fetch(`${path}/${username}/${id}`, {
        method: "GET"
    })
            .then(res => res.json())
            .then(data => {
                if (data === false) {
                    alert("Tên tài khoản đã tồn tại");
                } else{
                     alert("Tên tài khoản hợp lệ");
                }
            })
            .catch(error => {
                console.error(error);
            });
}

function checklichlam(path,id,date, idRole, idCa) {
//    alert("click được");
    fetch(`${path}/${id}/${date}/${idRole}/${idCa}`, {
        method: "GET"
    })
            .then(res => res.json())
            .then(data => {
                if (data === false && idRole === 2) {
                    alert("Đã quá số lượng bác sĩ có thể làm trong một ca");
                } else if (data === false && idRole === 3) {
                    alert("Đã quá số lượng y tá có thể làm trong một ca");
                } else if (data === true ){
                    alert("Đã xát nhận lịch thành công");
                    location.reload();
                } 
            })
            .catch(error => {
                console.error(error);
            });
}

function canhbaoxoataikhoan(pathcanhbao,id,idRole,path) {
//    alert("click được");
    fetch(`${pathcanhbao}/${id}`, {
        method: "GET"
    })
            .then(res => res.json())
            .then(data => {
//                alert(data);
                if (data !== 0 && idRole === 2) {
                    alert("Hệ thống sẽ mất hoàn toàn thông tin của Bác Sĩ cùng với dữ liệu của "+ data+" phiếu khám bệnh mà bác sĩ đã khám và hóa đơn sẽ thay đổi doanh thu của toàn hệ thống");
                    delObject(path, id);
                } else if (data !==0 && idRole === 3) {
                    alert("Hệ thống sẽ mất hoàn toàn thông tin của Y Tá cùng với dữ liệu của "+ data+" phiếu khám bệnh mà y tá đã xát nhận và hóa đơn sẽ thay đổi doanh thu của toàn hệ thống");
                    delObject(path, id);
                } else if (data !==0 && idRole === 4 ){
                    alert("Hệ thống sẽ mất hoàn toàn thông tin của Bệnh Nhân cùng với dữ liệu của "+ data+" phiếu khám bệnh mà bệnh nhân đã khám hay đã đăng ký và hóa đơn thanh toán của bệnh nhân sẽ thay đổi doanh thu của toàn hệ thống");
                    delObject(path, id);
                } if (data ===0){
                    alert("Hệ thống sẽ mất hoàn toàn thông tin của tài khoản");
                    delObject(path, id);
                }
            })
            .catch(error => {
                console.error(error);
            });
}

function canhbaoxoathuoc(pathcanhbao,id,path) {
//    alert("click được");
    fetch(`${pathcanhbao}/${id}`, {
        method: "GET"
    })
            .then(res => res.json())
            .then(data => {
//                alert(data);
                if (data !== 0) {
                    alert("Hệ thống sẽ mất hoàn toàn thông tin của thuốc cùng với dữ liệu của "+ data+" phiếu thuốc mà bác sĩ đã kê cho bệnh nhân, mất hết lịch sử kê thuốc lúc đó !!!");
                    delObject(path, id);
                } else {
                    alert("Hệ thống sẽ mất hoàn toàn thông tin của thuốc");
                    delObject(path, id);
                }
            })
            .catch(error => {
                console.error(error);
            });
}