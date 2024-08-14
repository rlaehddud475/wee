document.addEventListener('DOMContentLoaded', function() {
    const container = document.getElementById('checkbox-container');
    const rows = ['A', 'B', 'C', 'D', 'E'];
    const cols = [1, 2, 3, 4, 5];

    // 체크박스와 라벨을 동적으로 생성
    rows.forEach(row => {
        cols.forEach(col => {
            const value = `${row}${col}`;
            const checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.value = value;
            checkbox.name = 'camping_idx';
            checkbox.id = value;
            checkbox.className = 'custom-checkbox';

            const label = document.createElement('label');
            label.htmlFor = value;
            label.className = 'checkbox-label';
            label.textContent = value;

            container.appendChild(checkbox);
            container.appendChild(label);
        });
    });

    // 가격 계산 함수
    function updatePrice() {
        const numPeople = parseInt(document.getElementById('numberInput').value, 10);
        const priceElement = document.getElementById('price');
        const priceHiddenElement = document.getElementById('priceHidden');
        let price = 0;
        if (numPeople > 0) {
            if (numPeople <= 2) {
                price = numPeople * 10000;
            } else {
                price = 2 * 10000 + (numPeople - 2) * 3000;
            }
        }
        priceElement.textContent = '금액: ' + price.toLocaleString() + '원';
        priceHiddenElement.value = price;
    }

    // 초기 금액 설정 및 인원 수 변경 시 금액 업데이트
    document.getElementById('numberInput').value = 1;
    updatePrice();
    document.getElementById('numberInput').addEventListener('input', updatePrice);

    // 날짜 선택기 초기화
    $("#datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        minDate: 0,
        maxDate: "+1M +10D",
        changeMonth: true,
        changeYear: true,
        onSelect: function(selectedDate) {
            // 날짜가 선택되면 모든 체크박스를 초기화
            $("input[type='checkbox']").prop('checked', false);

            // AJAX 요청을 통해 예약된 좌석 정보를 가져옴
            $.ajax({
                url: '/findReservedSeatsByDate', // 서버의 실제 URL 확인
                method: 'GET', // 요청 방법이 적절한지 확인
                data: { date: selectedDate }, // 날짜를 쿼리 파라미터로 전송
                dataType: 'json', // 예상하는 응답 형식 설정
                success: function(response) {
                    console.log('서버 응답:', response); // 응답 확인
                    // 서버 응답이 JSON 배열일 경우, 각 체크박스의 상태를 업데이트
                    const reservedSeats = Array.isArray(response) ? response : [];
                    $("input[type='checkbox']").each(function() {
                        if (reservedSeats.includes(this.value)) {
                            $(this).prop('disabled', true);
                        } else {
                            $(this).prop('disabled', false);
                        }
                    });
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.error('AJAX 요청 오류:', {
                        status: jqXHR.status,
                        textStatus: textStatus,
                        errorThrown: errorThrown
                    });
                    alert('좌석 정보를 가져오는 데 오류가 발생했습니다.');
                }
            });
        }
    });

    // 체크박스를 하나만 선택하도록 설정
    $(document).on('click', "input[type='checkbox']", function() {
        const checkboxes = $("input[type='checkbox']");
        if (this.checked) {
            checkboxes.not(this).prop('checked', false);
        }
    });

    // 예약하기 버튼 클릭 시 날짜 값을 확인
    $("#reserveButton").on("click", function() {
        const selectedDate = $("#datepicker").val();
        if (!selectedDate) {
            alert('날짜를 선택해 주세요!');
        } else {
            console.log('선택된 날짜:', selectedDate);
            $("form[name='reservation_insert']").submit();
        }
    });

    // 로그아웃
    let $logoutButton = $("div[name='logout']");
    $logoutButton.on("click", function() {
        location.href="/logout";
    });
});	