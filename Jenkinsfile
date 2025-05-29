pipeline {
    agent any  // runs on any available Jenkins agent

    tools {
        maven 'Maven 3.8.6'    // You must configure this name in Jenkins > Tools
        jdk 'JDK 23'         // Or whatever version your project uses
    }

    stages {

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/KarimS101/Selenium_Java.git'
            }
        }

        stage('Build and Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: 'target/extent-report',
                    reportFiles: 'extent.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml' // Optional: parse test results
            cleanWs() // clean workspace after every build
        }
    }
}