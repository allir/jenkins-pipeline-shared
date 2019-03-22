
# jenkins-pipeline-shared

Shared libraries for Jenkins pipelines

## Usage

At the top of the pipeline script add the library and then call it's functions as normal pipeline steps.
Example:

```groovy
#!groovy
@Library('library_name_in_jenkins_settings') _ 

pipeline {
    ...
    stage('Start Build'){
        notifySlack
    }
    ...
    post{
        always{
            notifySlack currentBuild.result
        }
    }
}
```
