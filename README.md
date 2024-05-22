# Project05_FINDER

# 깃허브 협업 방법
- 원칙 : 작업은 내 로컬저장소에서 브랜치를 만들어서 한다.  ( main 에서는 작업하지 않는다 )
* 로컬 브랜치 생성 : git checkout -b [브랜치명] 

- 내가 작업한 변경사항이 있으면 
1) git add    2) git commit -m "커밋메시지"   3) git push 
=> 내 로컬 저장소 브랜치 -> 내 원격저장소 브랜치로 push
- 내 원격저장소에 push 한 것을 풀 리퀘스트 요청하고 원격 main에 합친다(merge). ( 다같이 같은 시간 )
- 원격저장소 main을 내 로컬 저장소 main에 pull 한다. ( 내 로컬 main 최신화 )
- 내 로컬저장소 브랜치에서 로컬 main을 merge한다. ( 로컬 브랜치에서 작업해서 위험부담 최소화 )
