build-clean-no-tests:
	mvn clean package -DskipTests
	cp target/*.jar docker
build-no-tests:
	mvn package -DskipTests
	cp target/*.jar docker
run:
	mvnw spring-boot:run
docker-compose-up:
	docker-compose -f docker/docker-compose.yml up
docker-compose-down:
	docker-compose -f docker/docker-compose.yml down
	docker-compose -f docker/docker-compose.yml rm -fsv

