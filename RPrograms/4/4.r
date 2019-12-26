#install.packages('party')
#install.packages('e1071')
#install.packages('caret')

library(party)
library(e1071)
library(caret)

data <- readingSkills
index <- sample(2,nrow(data),replace = TRUE,prob = c(0.7,0.3))

train <- data[index==1,]
test <- data[index==2,]

features <- nativeSpeaker ~ age + shoeSize + score 

model <- ctree(features,data=train)
plot(model)

test_predictions <- predict(model,newdata=test)
confusionMatrix(test_predictions,test$nativeSpeaker,positive="yes")

model2 <- naiveBayes(features,data=train)
print(model2)
test_predictions2 <- predict(model2,newdata=test)
confusionMatrix(test_predictions2,test$nativeSpeaker,positive="yes")