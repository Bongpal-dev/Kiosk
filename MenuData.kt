class MenuData {
    val bugers: List<Menu> = listOf(
        Menu("ShackBurger", 8400, "비프 패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
        Menu("SmokeShack", 10600, "베이컨, 체리 페퍼, 비프 패티와 쉑소스가 토핑된 치즈버거"),
        Menu("Shroom Burger", 10000, "포토벨로 버섯 패티에 양상추, 토마토, 쉑소스를 올린 베지테리안 버거"),
        Menu("Shack Stack", 14800, "포토벨로 버섯 패티, 비프 패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
        Menu("Hamburger", 6800, "포테이토 번과 비프 패티를 기본으로 토핑을 취향에 따라 선택할 수 있는 버거"),
    )

    val chicken: List<Menu> = listOf(
        Menu("Hot Chicken", 9500, "치킨 통살과 스파이시 슬로, 핫 스파이시 시즈닝이 토핑된 치킨 버거"),
        Menu("Chicken Shack", 8000, "치킨 통살과 양상추, 피클, 허브 마요 소스가 토핑된 치킨 버거"),
        Menu("Chick'n Bites", 5900, "한 입에 먹기 좋은 바삭한 치킨 바이트 (6-count)"),
    )

    val custard: List<Menu> = listOf(
        Menu("Classic Hand-Spun Shakes", 6500, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"),
        Menu("Floats", 6500, "바닐라 커스터드와 탄산이 만나 탄생한 색다른 음료"),
        Menu("Cup & Cones", 5400, "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림")
    )

    val concretes: List<Menu> = listOf(
        Menu("Shack Attack", 6200, "초콜릿 커스터드에 퍼지 소스와 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트"),
        Menu("Honey Butter Crunch", 6200, "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블렌딩된 콘크리트"),
        Menu("Better 2Gether", 6200, "바닐라와 초콜릿을 반씩 넣고 초콜릿 트러플 쿠키 도우와 쇼트브레드를 믹스한 특별한 콘크리트"),
        Menu("Shack-ffogato", 6200, "바닐라 커스터드에 커피가 어우러진 쉐이크쉑만의 아포가토 콘크리트"),
        Menu("Shack in the Garden", 6200, "바닐라 커스터드에 라즈베리 잼, 쇼트브레드와 말차가 달콤하게 블렌딩된 콘크리트")
    )

    val drinks: List<Menu> = listOf(
        Menu("Lemonade", 4300, "매장에서 직접 만드는 상큼한 레몬에이드"),
        Menu("Fresh Brewed Iced Tea", 3500, "직접 유기농 홍차를 우려낸 아이스 티"),
        Menu("Fifty/Fifty ", 3800, "레몬에이드와 아이스 티가 만나 탄생한 쉐이크쉑의 시그니처 음료"),
        Menu("Fountain Soda", 2900, "코카콜라, 코카콜라 제로, 스프라이트, 환타"),
        Menu("Abita Root Beer", 4800, "청량감 있는 독특한 미국식 무알콜 탄산음료"),
        Menu("Hot Tea", 3400, "보성 유기농 녹차, 홍차, 페퍼민트 & 레몬그라스")
    )

}