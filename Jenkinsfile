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
    // The options directive is for configuration that applies to the whole job.
    options {
        // For example, we'd like to make sure we only keep 10 builds at a time, so
        // we don't fill up our storage!
        buildDiscarder(logRotator(numToKeepStr:'10'))

        // And we'd really like to be sure that this build doesn't hang forever, so
        // let's time it out after an hour.
        timeout(time: 60, unit: 'MINUTES')
    }
}