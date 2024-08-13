const $submitForm = $("button#send_check");
$submitForm.on("click",function(event){
    event.preventDefault();   
    
    var formData = {
             subject: $('#subject').val(),
             name: $('#name').val(),
             content: $('#content').val(),
             pwd: $('#pwd').val()
         };


      
    $.ajax({
          url: '/insert?page=' + $('#page').val(),
          type: 'POST',
          contentType: 'application/json',
          data: JSON.stringify(formData),
          dataType: 'json',  // 응답을 JSON으로 처리
          success: function(response) {
              if (response.param === 'missing') {
                  alert('모든 필드를 입력해 주세요.');
                  window.location.href = '/insert_form';
              } else if (response.param === 'no') {
                  alert('입력값이 올바르지 않습니다.');
                  window.location.href = '/insert_form';
              } else if (response.param === 'yes') {
                  alert('등록 성공!');
                  window.location.href = '/events_board'; // 예시 리디렉션
              } else {
                  alert('서버 오류 발생.');
              }
          },
          error: function() {
              alert('서버와의 통신 중 오류가 발생했습니다.');
          }
      });
});