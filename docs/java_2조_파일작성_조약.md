# 0511_코드리뷰

## 1. 개인별 작업 및 주요 내용

### 천사무엘님
* [cite_start]쿠폰DAO부터 작업하려 했으나, 내 자산, 뉴스 인터페이스와 MybatisDAO를 먼저 생성함. [cite: 3]
* [cite_start]쿠폰 Interface에서 Override를 통해 Mybatis용 DAO를 만듦. [cite: 4]
* [cite_start]`stockGameMapper.xml` 한 파일에 모든 쿼리문을 다 넣어 한눈에 볼 수 있도록 함. [cite: 5]
* [cite_start]뉴스와 내 자산 쿼리를 먼저 작성하는 방식으로 진행함. [cite: 6]
* [cite_start]Map을 사용하지 않고, VO 내에서 새로운 생성자를 만들어 활용함. [cite: 7]
* [cite_start]쿠폰 구매의 리턴 타입이 boolean일 경우 실패 시 false를 반환함. [cite: 8]
* [cite_start]멤버DAO 관련 매서드 명의 수정 논의가 필요함. [cite: 9]
* [cite_start]내 자산 부분에서는 Map일 때 파라미터를 던짐. [cite: 10]
* [cite_start]커밋명이 모두 동일하여 커밋명 규칙이 필요함. [cite: 11]
* [cite_start]테스트 코드 작성 규칙과 테스트 코드 명 규칙 설정이 요구됨. [cite: 12]
* [cite_start]테스트 코드는 전부 AI를 활용하여 작성함. [cite: 13]

### 최동석님
* [cite_start]DAO 패키지 내부를 mybatis와 jdbc로 나누어 패키지를 명확히 구분함. [cite: 15]
* [cite_start]Mapper는 기존 쿼리문을 구분했던 방식대로 분리함. [cite: 16]
* [cite_start]JDBC를 더 이상 사용하지 않을 것 같아 직관성을 높이기 위해 `DBCPMybatis` 파일명을 `SqlSessionManager`로 수정하고 dbcp를 삭제함. [cite: 17]
* [cite_start]테스트 코드도 Mybatis용으로 분리하여 작성함. [cite: 18]
* [cite_start]Dao 패키지 안에 인터페이스를 작성함. [cite: 19]
* [cite_start]Return 타입 명을 매서드명과 유사하게 작성함. [cite: 20]
* [cite_start]DAOMybatis에서 try, finally 구조를 적용함. [cite: 21]
* [cite_start]int로 받는 값은 모두 Integer 객체로 받도록 처리함. [cite: 22]
* [cite_start]Boolean 값은 flag 변수로 명명하여 작성함. [cite: 23]

---

## 2. 주요 논의 사항

### 인화
* [cite_start]멤버DAO 관련 매서드의 DAOMybatis, DAO 및 `mapper.xml` id명 통일이 필요함. [cite: 26]
* [cite_start]데이터를 Map으로 던질지, VO로 던질지에 대한 논의가 필요함. [cite: 27]
* [cite_start]커밋명이 모두 동일하여 커밋 규칙 정립이 필요함. [cite: 28]
* [cite_start]테스트 코드 작성 규칙 및 명명 규칙 설정이 필요함. [cite: 29]
* [cite_start]폴더명 및 파일 구조를 고정해야 함. [cite: 30]
* [cite_start]쿼리문 XML의 분리 여부에 대한 논의가 필요함. [cite: 31]
* [cite_start]Return 타입(result/flag/true/false)에 대한 결정이 필요함. [cite: 32]

### 사무엘님
* [cite_start]폴더 구조에 대한 논의 제안. [cite: 34]
* [cite_start]매서드명 규칙에 대한 논의 제안. [cite: 35]
* [cite_start]Return 형식에 대한 논의 제안. [cite: 36]

### 동석님
* [cite_start]VO 사용 여부와 Map 사용 여부 논의 제안. [cite: 38]
* [cite_start]파일명 명명 규칙 논의 제안. [cite: 39]
* [cite_start]쿼리문 아이디명 규칙 논의 제안. [cite: 40]
* [cite_start]쿼리문 XML 분리 여부 논의 제안. [cite: 41]
* [cite_start]테스트 코드 선언부의 한글/영어 사용 여부 및 구현 규칙 논의 제안. [cite: 42]
* [cite_start]폴더 구조 논의 제안. [cite: 43]
* [cite_start]매서드명 논의 제안. [cite: 44]

* [cite_start]개발 용어 정리의 중요성 강조. [cite: 45]

---

## 3. 합의된 규칙 정리

### 폴더 구조 및 파일명
* [cite_start]`dao` 패키지 안에는 interface 파일만 위치함. [cite: 47, 53]
* [cite_start]`jdbc` 패키지 안에는 기존 DAO 파일이 위치함. [cite: 48, 54]
* [cite_start]`mybatis` 패키지 안에는 DAOMybatis 파일이 위치함. [cite: 49, 55]
* [cite_start]`config` 패키지 안에는 DAO를 나눈 기준과 동일하게 `mapper.xml`을 분리하여 저장함. [cite: 50, 56]
* [cite_start]`test` 패키지 안에는 DAOTest와 DAOMybatisTest를 구분하여 저장함. [cite: 51, 57]

### 매서드명 및 쿼리명 id 규칙
* [cite_start]로그인 등 명확한 매서드명은 기존 이름을 그대로 사용하는 것을 권장함. [cite: 59]
* [cite_start]Login 관련 매서드는 추후 발견 시 무조건 팀원에게 알릴 것. [cite: 60, 61]
* [cite_start]Interface 선언부와 daomybatis에 있는 매서드명을 동일하게 통일함. [cite: 63]
* [cite_start]로그인을 제외한 모든 매서드는 get/set 접두사를 사용하여 작성함. [cite: 63]

### Return 명명 규칙
* [cite_start]Return으로 넘기는 데이터는 수식 처리나 세션 처리 없이 값 자체만 던짐. [cite: 65]
* [cite_start]Return으로 던지는 변수 값의 이름은 따로 정하지 않고 자유롭게 사용함. [cite: 66]

### Map vs VO 사용 기준
* [cite_start]**인화:** 본인 재량에 맡기되, 기존 VO에 생성자를 추가하는 것은 허용하나, 기존 VO 필드 수정은 불가함 (추가만 허용). [cite: 68]
* [cite_start]**동석:** 본인 재량에 맡기지만, Map 사용 시 코드가 길어지므로 VO 사용을 권장함. [cite: 69]
* [cite_start]**사무엘:** 다른 두 팀원의 의견에 따름. [cite: 70]

### 테스트 코드 및 Git 규칙
* [cite_start]**테스트 코드:** 선언부는 영어로 작성하며, 테스트 코드 구현 규칙은 1, 2, 3 단계로 구성함. [cite: 71]
* [cite_start]**커밋 규칙:** 커밋명과 커밋 규칙은 노션에 정리된 가이드를 따름. [cite: 72, 73]
* **Github 작업:**
    * [cite_start]Default 브랜치를 따서 개별 작업을 진행함. [cite: 74, 75]
    * [cite_start]Main 브랜치로의 병합은 최종 마지막 발표 직전에만 일괄 진행함. [cite: 76]
    * [cite_start]브랜치나 커밋 앞에 `Refactor` 태그를 붙여야 함. [cite: 77]
    * [cite_start]`Feature` 태그를 붙일 경우 임의로 삭제 조치할 예정임. [cite: 78]