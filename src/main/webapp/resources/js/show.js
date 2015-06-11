$(document).ready(function(){
			// Validate form
			$("#tutorial").validate({
				errorElement: "span", // Định dạng cho thẻ HTML hiện thông báo lỗi
				submitHandler: function(form) {
				
					// Validate thành công sẽ lấy dữ liệu từ form và gởi đến test.php
					var id= $('#sh').attr('value');
				 		$.ajax({
						type: "GET", // phương thức gởi đi
						url: "/thymeleafpage", // nơi mà dữ liệu sẽ chuyển đến khi submit
						data: "?limit="+ id, // giá trị post
						success: function(answer){ // if everything goes well
							$('form#tutorial').hide(); // ẩn form đi
							$('div.success').fadeIn(); // hiển thị thẻ div success
							$('div.success').html(answer); // đặt kết quả trả về từ test.php vào thẻ div success
						}
					});
					return false;  // Form sẽ không chuyển đến trang test.php
					 
				 }
			});
		});