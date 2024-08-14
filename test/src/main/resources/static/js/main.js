// 동규님
let $logout = $("div[name='logout']");
		$logout.on("click", function() {
			location.href="/logout";
		})

// 용빈님
if (document.getElementById('success-message') != null) {
   alert("예약이 완료되었습니다!");
}

// 로그인을 하지않고 예약을 클릭시 오류가 발생할떼 나오는 경고창
var errorMessageElement = document.getElementById('reservation_error');
      if (errorMessageElement) {
         alert("로그인 후 이용해 주세요!");
      }
	  $(document).ready(function() {
	      const blockListSize = 10; // 페이지당 항목 수

	      function loadSubjects(page = 1) {
	          $.ajax({
	              url: '/getSubjects',
	              method: 'GET',
	              data: { page: page },
	              success: function(data) {
	                  const $eventsList = $('#events-list');
	                  const $pagination = $('#pagination');

	                  $eventsList.empty();
	                  $pagination.empty();

	                  // 제목 리스트 로드
	                  data.subjects.forEach(subject => {
	                      $eventsList.append(`<li>${subject}</li>`);
	                  });

	                  // 페이지 네비게이션 로드
	                  $pagination.html(data.pageMenu);

	                  // 페이지 네비게이션 클릭 이벤트 설정
	                  $('.page-btn').on('click', function() {
	                      const selectedPage = $(this).data('page');
	                      loadSubjects(selectedPage);
	                  });
	              },
	              error: function(jqXHR, textStatus, errorThrown) {
	                  console.error('AJAX request failed:', textStatus, errorThrown);
	              }
	          });
	      }

	      loadSubjects(); // 초기 데이터 로드
	  });