pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean install verify'
                junit '**/target/surefire-reports/TEST-*.xml'
                checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '', unHealthy: ''
            }

            post {
                success {

                    echo "Success"
                }
            }
        }
        stage('SonarQube analysis') {
            steps {
                script {
                  // requires SonarQube Scanner 2.8+
                  scannerHome = tool 'SonarQube Scanner 3.0.3'
                }
                withSonarQubeEnv('Sonar Server 6.4') {
                  sh 'mvn sonar:sonar'

                }
              }
          }
    }
}