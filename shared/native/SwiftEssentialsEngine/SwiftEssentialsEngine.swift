import Foundation
import UIKit

@objc class LocalNotificationManager : NSObject {
    func requestNotificationPermission(onResponse: @escaping () -> Void, onError: @escaping (String) -> Void){
        UNUserNotificationCenter.current().requestAuthorization(options: [.alert, .badge, .sound]){ (granted, error) in
            if(granted){
                onResponse()
            }
            else {
                onError(error?.localizedDescription ?? "Failed to request notification permission")
            }
        }
    }
}
