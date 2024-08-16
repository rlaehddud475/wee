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
	      let currentPage = 1;
	      const blockListSize = 10; // 페이지당 항목 수

	      function loadSubjects(page = 1) {
	          $.ajax({
	              url: '/getSubjects',
	              method: 'GET',
	              data: { page: page },
	              success: function(data) {
	                  const $eventsList = $('#events-list');

	                  // 빈 목록 초기화
	                  if (page === 1) {
	                      $eventsList.empty();
	                  }

	                  // 제목 리스트 로드
	                  data.subjects.forEach(subject => {
	                      $eventsList.append(`
	                          <li>
	                              <a href="/views?idx=${subject.id}&page=${page}">${subject.title}</a>
	                          </li>
	                      `);
	                  });

	                  // 페이지 업데이트
	                  currentPage = page;
	              },
	              error: function(jqXHR, textStatus, errorThrown) {
	                  console.error('AJAX request failed:', textStatus, errorThrown);
	              }
	          });
	      }

	      // 스크롤 이벤트 핸들러
	      $(window).scroll(function() {
	          if ($(window).scrollTop() + $(window).height() >= $(document).height()) {
	              loadSubjects(currentPage + 1);
	          }
	      });

	      // 초기 데이터 로드
	      loadSubjects();
	  });