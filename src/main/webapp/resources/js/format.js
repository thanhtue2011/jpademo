$(document).ready(function(){
			// Validate form
			$("#tutorial").validate({
				errorElement: "span", // Định dạng cho thẻ HTML hiện thông báo lỗi
				submitHandler: function(form) {
				
					// Validate thành công sẽ lấy dữ liệu từ form và gởi đến test.php
					var id= $('#id').attr('value');
					var name= $('#name').attr('value');
					var firstname= $('#firstname').attr('value');
					var lastname= $('#lastname').attr('value');
				 
					$.ajax({
						type: "POST", // phương thức gởi đi
						url: "/Springexample/saveAccount", // nơi mà dữ liệu sẽ chuyển đến khi submit
						data: "&id="+ id +"&name="+ name +"&firstname="+ firstname +"&lastname="+ lastname, // giá trị post
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