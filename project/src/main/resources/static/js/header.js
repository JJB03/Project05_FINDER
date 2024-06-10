$(document).ready(function() {

    let accessOrder = $('#accessOrder').val();

    console.log("accessOrder: " + accessOrder); // 디버깅용 콘솔 로그

    $('#paymentLink').click(function(event) {
        if (accessOrder == '1') { // accessOrder가 문자열 형태일 수 있으므로 '1'로 비교
            event.preventDefault();
            alert("잔여 주문내역이 있습니다.\n미결제 내역은 결제 페이지에서 확인하세요.");
        } else {
            window.location.href = $(this).attr('th:href');
        }
    });
});