FROM openjdk:11

COPY . /java

WORKDIR /java

EXPOSE 8001

RUN javac MillionaireApplication.java

CMD [ "java" , "MillionaireApplication" ]