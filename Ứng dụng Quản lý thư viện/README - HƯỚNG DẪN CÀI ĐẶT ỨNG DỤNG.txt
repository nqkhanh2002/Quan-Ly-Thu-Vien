* ĐỐI VỚI BẢN "library_management_final_remote" thì chỉ cần build và chạy bình thường, tuy nhiên
vì là server remote free nên thỉnh thoảng sẽ có traffic gây chậm hoặc văng ứng dụng.

* ĐỐI VỚI BẢN "library_management_final_local" thì là bản chạy trên localhost, cần bật XAMPP và mở
PHPMyAdmin trên localhost sau đó tạo cơ sở dữ liệu đúng với tên của file SQL đã gửi (cụ thể là cơ
sở dữ liệu tên "sql6424812", để định dạng là "utf8_general_ci", sau đó import file SQL đã gửi lên
("sql6424812.sql"), để mặc định là "utf8" và tiến hành import. Khi đó thành công cơ sở dữ liệu sẽ
có đầy đủ các bảng và dữ liệu tương ứng. Lúc này có thể build và chạy ứng dụng bình thường như bản
remote.