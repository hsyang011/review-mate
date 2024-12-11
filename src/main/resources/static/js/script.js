function searchItem() {
    const searchTerm = document.getElementById('search').value;
    if (searchTerm) {
        alert(`"${searchTerm}"에 대한 검색 결과를 보여줍니다.`);
    } else {
        alert("검색어를 입력해주세요.");
    }
}
