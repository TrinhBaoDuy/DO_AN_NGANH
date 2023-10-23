# DO_AN_NGANH
1) Download file từ link github:
	- Truy cập vào link github: https://github.com/TrinhBaoDuy/DO_AN_NGANH.
	- Click vào code => copy địa chỉ HTTPS.
	- Trên máy tính: vào thư mục muốn lưu file => chuột phải => git bash here => nhập vào git clone "tên đường dẫn vừa copy".
2) Nạp cơ sở dữ liệu
	- Mở MySQL Workbench
	- Tạo một schema có tên là clinnicdb và nhấn double vào schema để Set as Default Schema.
	- Mở vào file dbclinic.sql trong file DO_AN_NGANH vừa clone về bằng Notepad, ctrl + A và coppy.
	- Mở một file SQL pass dữ liệu vào và chạy.
	- Refresh lại trang để kiểm tra Tables được nạp hay chưa.
	
3) Mở file 
	- Mở Apache NetBean với JDK là 14 để tương thích môi trường.
	- Mở project "Clinnic" vừa clone về ( trong file DO_AN_NGANH ).
	- Trỏ vào Clinnic/Other Sources/<default package>/databases.properties.
	- Thay đổi username và password theo MySQL Workbench của bạn 
	{
		hibernate.connection.username= "username của bạn"
		hibernate.connection.password= "password của bạn"
	}
	- Nhấn chuột phải vào project "Clinnic" chọn Build.
	- Khi thành công quá trình build thì dưới output sẽ hiện BUILD SUCCESS.
	- Nhấn chuột phải vào project "Clinnic" chọn Run.
	- Điền passwword Tomcat của bạn, nhấn OK.
	- Đợi chạy và nó sẽ thành công khi tab run hiện thông báo "OK - Started application at context path [/Clinnic]".
