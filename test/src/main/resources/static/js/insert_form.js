$(document).ready(function() {
    $('#send_check').on('click', function(event) {
        event.preventDefault(); // 폼 기본 제출 방지

        // 폼 데이터 수집
        var formData = {
            subject: $('#subject').val(),
            name: $('#name').val(),
            content: $('#content').val(),
            pwd: $('#pwd').val()
        };

        console.log("Form Data:", formData); // 폼 데이터 콘솔 로그 추가

        $.ajax({
            url: '/insert?page=' + $('#page').val(), // URL에 페이지 번호 추가
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(response) {
                console.log("Response received:", response);

                // JSON 문자열 파싱
                var responseObj = response; // 서버가 이미 JSON 객체를 반환한다고 가정

                if (responseObj.param === 'missing') {
                    alert('모든 필드를 입력해 주세요.');
                    // 폼을 다시 로드하여 사용자가 입력할 수 있도록 함
                    window.location.href = '/insert_form?page=' + $('#page').val();
                } else if (responseObj.param === 'no') {
                    alert('입력값이 올바르지 않습니다.');
                    window.location.href = '/insert_form?page=' + $('#page').val();
                } else if (responseObj.param === 'yes') {
                    alert('등록 성공!');
                    // 데이터 전송 후 이벤트 보드로 리다이렉트
                    window.location.href = '/events_board?page=' + $('#page').val();
                } else {
                    alert('서버 오류 발생.');
                }
            },
            error: function(xhr, status, error) {
                console.log("AJAX Error:", status, error);
                alert('서버와의 통신 중 오류가 발생했습니다.');
            }
        });
    });
});