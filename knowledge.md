# 部署到 OSSRH 和 Central Repository
mvn clean deploy -DcreateChecksum=true 

mvn install -DcreateChecksum=true
