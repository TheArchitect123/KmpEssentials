#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class KmpEssentialsKmpiOS, UIViewController, CMMotionManager, KmpEssentialsKmpAccelerometerCompanion, KmpEssentialsKotlinTriple<__covariant A, __covariant B, __covariant C>, KmpEssentialsKmpAlertCompanion, KmpEssentialsKmpAppActionsCompanion, KmpEssentialsKotlinEnumCompanion, KmpEssentialsKotlinEnum<E>, KmpEssentialsAppDeviceTheme, KmpEssentialsKotlinArray<T>, KmpEssentialsKmpAppInfoCompanion, KmpEssentialsKmpAudioCompanion, KmpEssentialsKmpBackButtonCompanion, KmpEssentialsBackgroundOptions, KmpEssentialsKmpBackgroundingCompanion, KmpEssentialsKmpForegroundServiceCompanion, KmpEssentialsKmpBatteryCompanion, KmpEssentialsBatteryChargeState, KmpEssentialsBatteryPowerSource, KmpEssentialsBatteryHealth, KmpEssentialsEnergySaverStatus, KmpEssentialsKmpBiometricsCompanion, KmpEssentialsKmpCalendarCompanion, KmpEssentialsCalendarInfo, KmpEssentialsEventParticipants, KmpEssentialsKmpCameraCompanion, KmpEssentialsKmpClipboardCompanion, KmpEssentialsKmpConnectivityCompanion, KmpEssentialsContact, KmpEssentialsKmpContactsCompanion, KmpEssentialsKmpDeviceDisplayCompanion, KmpEssentialsDevicePlatform, KmpEssentialsDeviceSpecs, KmpEssentialsDeviceType, KmpEssentialsKmpDeviceInfoCompanion, KmpEssentialsKmpEmailCompanion, KmpEssentialsFile, KmpEssentialsKmpFilePickerCompanion, KmpEssentialsKmpFileSystemCompanion, KmpEssentialsFlashLightMode, KmpEssentialsKmpFlashlightCompanion, KmpEssentialsKmpGeolocationCompanion, KmpEssentialsLocation, KmpEssentialsKmpGyroscopeCompanion, KmpEssentialsMimes, KmpEssentialsKmpLauncherCompanion, KmpEssentialsKmpLifecycleCompanion, KmpEssentialsKmpLocalNotificationsCompanion, KmpEssentialsKmpLoggingCompanion, KmpEssentialsKotlinException, KmpEssentialsKmpMagnometerCompanion, KmpEssentialsKmpMainThreadCompanion, KmpEssentialsKmpMediaPickerCompanion, KmpEssentialsKmpOrientationManagerCompanion, KmpEssentialsOrientationState, KmpEssentialsKmpPermissionsManagerCompanion, KmpEssentialsPermission, KmpEssentialsPermissionStatus, KmpEssentialsKmpPrintingCompanion, KmpEssentialsKmpProximityCompanion, KmpEssentialsKmpPromptReviewCompanion, KmpEssentialsKmpScreenshotCompanion, KmpEssentialsKmpPublicStorageCompanion, KmpEssentialsKmpSecureStorageCompanion, KmpEssentialsKmpShareCompanion, KmpEssentialsKmpSmsCompanion, KmpEssentialsKmpTelecomCompanion, KmpEssentialsKmpTextToSpeechCompanion, KmpEssentialsKmpToastCompanion, KmpEssentialsKmpVibrationCompanion, KmpEssentialsKotlinThrowable, KmpEssentialsKotlinRuntimeException, KmpEssentialsKotlinIllegalStateException;

@protocol KmpEssentialsKotlinComparable, KmpEssentialsKotlinSuspendFunction0, KmpEssentialsKotlinIterator, KmpEssentialsKotlinFunction;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface KmpEssentialsBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface KmpEssentialsBase (KmpEssentialsBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface KmpEssentialsMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface KmpEssentialsMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorKmpEssentialsKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface KmpEssentialsNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface KmpEssentialsByte : KmpEssentialsNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface KmpEssentialsUByte : KmpEssentialsNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface KmpEssentialsShort : KmpEssentialsNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface KmpEssentialsUShort : KmpEssentialsNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface KmpEssentialsInt : KmpEssentialsNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface KmpEssentialsUInt : KmpEssentialsNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface KmpEssentialsLong : KmpEssentialsNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface KmpEssentialsULong : KmpEssentialsNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface KmpEssentialsFloat : KmpEssentialsNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface KmpEssentialsDouble : KmpEssentialsNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface KmpEssentialsBoolean : KmpEssentialsNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpiOS")))
@interface KmpEssentialsKmpiOS : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)kmpiOS __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpiOS *shared __attribute__((swift_name("shared")));
- (UIViewController * _Nullable)getTopViewController __attribute__((swift_name("getTopViewController()")));
@property (readonly) CMMotionManager *motionManager __attribute__((swift_name("motionManager")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAccelerometer")))
@interface KmpEssentialsKmpAccelerometer : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpAccelerometerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAccelerometer.Companion")))
@interface KmpEssentialsKmpAccelerometerCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpAccelerometerCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningAccScopeVal:(void (^)(KmpEssentialsKotlinTriple<KmpEssentialsFloat *, KmpEssentialsFloat *, KmpEssentialsFloat *> *))accScopeVal __attribute__((swift_name("startListening(accScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAlert")))
@interface KmpEssentialsKmpAlert : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpAlertCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAlert.Companion")))
@interface KmpEssentialsKmpAlertCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpAlertCompanion *shared __attribute__((swift_name("shared")));
- (void)showAlertMessage:(NSString *)message title:(NSString *)title __attribute__((swift_name("showAlert(message:title:)")));
- (void)showAlertMessage:(NSString *)message title:(NSString *)title okText:(NSString *)okText okAction:(void (^)(void))okAction __attribute__((swift_name("showAlert(message:title:okText:okAction:)")));
- (void)showAlertWithConfirmationMessage:(NSString *)message title:(NSString *)title okText:(NSString *)okText cancelText:(NSString *)cancelText okAction:(void (^)(void))okAction cancelAction:(void (^)(void))cancelAction __attribute__((swift_name("showAlertWithConfirmation(message:title:okText:cancelText:okAction:cancelAction:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppActions")))
@interface KmpEssentialsKmpAppActions : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpAppActionsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppActions.Companion")))
@interface KmpEssentialsKmpAppActionsCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpAppActionsCompanion *shared __attribute__((swift_name("shared")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((swift_name("KotlinComparable")))
@protocol KmpEssentialsKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface KmpEssentialsKotlinEnum<E> : KmpEssentialsBase <KmpEssentialsKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) KmpEssentialsKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppDeviceTheme")))
@interface KmpEssentialsAppDeviceTheme : KmpEssentialsKotlinEnum<KmpEssentialsAppDeviceTheme *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsAppDeviceTheme *dark __attribute__((swift_name("dark")));
@property (class, readonly) KmpEssentialsAppDeviceTheme *light __attribute__((swift_name("light")));
@property (class, readonly) KmpEssentialsAppDeviceTheme *system __attribute__((swift_name("system")));
+ (KmpEssentialsKotlinArray<KmpEssentialsAppDeviceTheme *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsAppDeviceTheme *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppInfo")))
@interface KmpEssentialsKmpAppInfo : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpAppInfoCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppInfo.Companion")))
@interface KmpEssentialsKmpAppInfoCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpAppInfoCompanion *shared __attribute__((swift_name("shared")));
- (int32_t)getPackageMinOS __attribute__((swift_name("getPackageMinOS()")));
- (NSString *)getPackageName __attribute__((swift_name("getPackageName()")));
- (NSString *)getPackageVersion __attribute__((swift_name("getPackageVersion()")));
- (int32_t)getPackageVersionCode __attribute__((swift_name("getPackageVersionCode()")));
- (KmpEssentialsAppDeviceTheme *)getSystemThemeMode __attribute__((swift_name("getSystemThemeMode()")));
- (void)isRunningInBackgroundAction:(void (^)(KmpEssentialsBoolean *))action __attribute__((swift_name("isRunningInBackground(action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAudio")))
@interface KmpEssentialsKmpAudio : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpAudioCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAudio.Companion")))
@interface KmpEssentialsKmpAudioCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpAudioCompanion *shared __attribute__((swift_name("shared")));
- (void)playAudioFileWithPathFilePath:(NSString *)filePath __attribute__((swift_name("playAudioFileWithPath(filePath:)")));
- (void)recordVoiceAndReturnFilePathActionParams:(void (^)(NSString *))actionParams __attribute__((swift_name("recordVoiceAndReturnFilePath(actionParams:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackButton")))
@interface KmpEssentialsKmpBackButton : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpBackButtonCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackButton.Companion")))
@interface KmpEssentialsKmpBackButtonCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpBackButtonCompanion *shared __attribute__((swift_name("shared")));
- (void)disableBackButton __attribute__((swift_name("disableBackButton()")));
- (void)disableBackButtonOverrideWithCustomActionCustomAction:(void (^)(void))customAction __attribute__((swift_name("disableBackButtonOverrideWithCustomAction(customAction:)")));
- (void)enableBackButton __attribute__((swift_name("enableBackButton()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BackgroundOptions")))
@interface KmpEssentialsBackgroundOptions : KmpEssentialsBase
- (instancetype)initWithRequiresInternet:(BOOL)requiresInternet requiresStorage:(BOOL)requiresStorage requiresSufficientBattery:(BOOL)requiresSufficientBattery __attribute__((swift_name("init(requiresInternet:requiresStorage:requiresSufficientBattery:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsBackgroundOptions *)doCopyRequiresInternet:(BOOL)requiresInternet requiresStorage:(BOOL)requiresStorage requiresSufficientBattery:(BOOL)requiresSufficientBattery __attribute__((swift_name("doCopy(requiresInternet:requiresStorage:requiresSufficientBattery:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL requiresInternet __attribute__((swift_name("requiresInternet")));
@property (readonly) BOOL requiresStorage __attribute__((swift_name("requiresStorage")));
@property (readonly) BOOL requiresSufficientBattery __attribute__((swift_name("requiresSufficientBattery")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackgrounding")))
@interface KmpEssentialsKmpBackgrounding : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpBackgroundingCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackgrounding.Companion")))
@interface KmpEssentialsKmpBackgroundingCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpBackgroundingCompanion *shared __attribute__((swift_name("shared")));
- (void)cancelAllRunningWorkers __attribute__((swift_name("cancelAllRunningWorkers()")));
- (void)createAndStartForegroundWorkerTitle:(NSString *)title message:(NSString *)message action:(id<KmpEssentialsKotlinSuspendFunction0>)action __attribute__((swift_name("createAndStartForegroundWorker(title:message:action:)")));
- (void)createAndStartWorkerOptions:(KmpEssentialsBackgroundOptions * _Nullable)options action:(id<KmpEssentialsKotlinSuspendFunction0>)action __attribute__((swift_name("createAndStartWorker(options:action:)")));
- (void)createAndStartWorkerWithoutCancelOptions:(KmpEssentialsBackgroundOptions * _Nullable)options action:(id<KmpEssentialsKotlinSuspendFunction0>)action __attribute__((swift_name("createAndStartWorkerWithoutCancel(options:action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpForegroundService")))
@interface KmpEssentialsKmpForegroundService : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpForegroundServiceCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpForegroundService.Companion")))
@interface KmpEssentialsKmpForegroundServiceCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpForegroundServiceCompanion *shared __attribute__((swift_name("shared")));
- (void)registerBackgroundService __attribute__((swift_name("registerBackgroundService()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBattery")))
@interface KmpEssentialsKmpBattery : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpBatteryCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBattery.Companion")))
@interface KmpEssentialsKmpBatteryCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpBatteryCompanion *shared __attribute__((swift_name("shared")));
- (int64_t)getCurrentChargeLevel __attribute__((swift_name("getCurrentChargeLevel()")));
- (KmpEssentialsBatteryChargeState *)getCurrentChargeState __attribute__((swift_name("getCurrentChargeState()")));
- (KmpEssentialsBatteryPowerSource *)getCurrentPowerSource __attribute__((swift_name("getCurrentPowerSource()")));
- (BOOL)isEnergySaverOn __attribute__((swift_name("isEnergySaverOn()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BatteryChargeState")))
@interface KmpEssentialsBatteryChargeState : KmpEssentialsKotlinEnum<KmpEssentialsBatteryChargeState *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsBatteryChargeState *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) KmpEssentialsBatteryChargeState *charging __attribute__((swift_name("charging")));
@property (class, readonly) KmpEssentialsBatteryChargeState *discharging __attribute__((swift_name("discharging")));
@property (class, readonly) KmpEssentialsBatteryChargeState *full __attribute__((swift_name("full")));
@property (class, readonly) KmpEssentialsBatteryChargeState *notcharging __attribute__((swift_name("notcharging")));
@property (class, readonly) KmpEssentialsBatteryChargeState *notpresent __attribute__((swift_name("notpresent")));
+ (KmpEssentialsKotlinArray<KmpEssentialsBatteryChargeState *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsBatteryChargeState *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BatteryHealth")))
@interface KmpEssentialsBatteryHealth : KmpEssentialsKotlinEnum<KmpEssentialsBatteryHealth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsBatteryHealth *cold __attribute__((swift_name("cold")));
@property (class, readonly) KmpEssentialsBatteryHealth *dead __attribute__((swift_name("dead")));
@property (class, readonly) KmpEssentialsBatteryHealth *good __attribute__((swift_name("good")));
@property (class, readonly) KmpEssentialsBatteryHealth *overheat __attribute__((swift_name("overheat")));
@property (class, readonly) KmpEssentialsBatteryHealth *overcharge __attribute__((swift_name("overcharge")));
@property (class, readonly) KmpEssentialsBatteryHealth *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) KmpEssentialsBatteryHealth *failure __attribute__((swift_name("failure")));
+ (KmpEssentialsKotlinArray<KmpEssentialsBatteryHealth *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsBatteryHealth *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BatteryPowerSource")))
@interface KmpEssentialsBatteryPowerSource : KmpEssentialsKotlinEnum<KmpEssentialsBatteryPowerSource *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsBatteryPowerSource *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) KmpEssentialsBatteryPowerSource *battery __attribute__((swift_name("battery")));
@property (class, readonly) KmpEssentialsBatteryPowerSource *ac __attribute__((swift_name("ac")));
@property (class, readonly) KmpEssentialsBatteryPowerSource *usb __attribute__((swift_name("usb")));
@property (class, readonly) KmpEssentialsBatteryPowerSource *wireless __attribute__((swift_name("wireless")));
+ (KmpEssentialsKotlinArray<KmpEssentialsBatteryPowerSource *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsBatteryPowerSource *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EnergySaverStatus")))
@interface KmpEssentialsEnergySaverStatus : KmpEssentialsKotlinEnum<KmpEssentialsEnergySaverStatus *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsEnergySaverStatus *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) KmpEssentialsEnergySaverStatus *on __attribute__((swift_name("on")));
@property (class, readonly) KmpEssentialsEnergySaverStatus *off __attribute__((swift_name("off")));
+ (KmpEssentialsKotlinArray<KmpEssentialsEnergySaverStatus *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsEnergySaverStatus *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBiometrics")))
@interface KmpEssentialsKmpBiometrics : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpBiometricsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBiometrics.Companion")))
@interface KmpEssentialsKmpBiometricsCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpBiometricsCompanion *shared __attribute__((swift_name("shared")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
- (void)scanBiometricsActionResult:(void (^)(KmpEssentialsBoolean *))actionResult actionError:(void (^)(NSString *))actionError __attribute__((swift_name("scanBiometrics(actionResult:actionError:)")));
- (void)setPromptInfoTitle:(NSString *)title message:(NSString *)message __attribute__((swift_name("setPromptInfo(title:message:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpCalendar")))
@interface KmpEssentialsKmpCalendar : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpCalendarCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpCalendar.Companion")))
@interface KmpEssentialsKmpCalendarCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpCalendarCompanion *shared __attribute__((swift_name("shared")));
- (NSString *)addCalendarEventEventInfo:(KmpEssentialsCalendarInfo *)eventInfo __attribute__((swift_name("addCalendarEvent(eventInfo:)")));
- (BOOL)removeCalendarEventEventId:(NSString *)eventId __attribute__((swift_name("removeCalendarEvent(eventId:)")));
- (NSString *)updateCalendarEventEventId:(NSString *)eventId eventInfo:(KmpEssentialsCalendarInfo *)eventInfo __attribute__((swift_name("updateCalendarEvent(eventId:eventInfo:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CalendarInfo")))
@interface KmpEssentialsCalendarInfo : KmpEssentialsBase
- (instancetype)initWithEventName:(NSString *)eventName eventDescription:(NSString *)eventDescription eventLocation:(NSString *)eventLocation participants:(NSArray<KmpEssentialsEventParticipants *> * _Nullable)participants msFromNow:(int64_t)msFromNow __attribute__((swift_name("init(eventName:eventDescription:eventLocation:participants:msFromNow:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsCalendarInfo *)doCopyEventName:(NSString *)eventName eventDescription:(NSString *)eventDescription eventLocation:(NSString *)eventLocation participants:(NSArray<KmpEssentialsEventParticipants *> * _Nullable)participants msFromNow:(int64_t)msFromNow __attribute__((swift_name("doCopy(eventName:eventDescription:eventLocation:participants:msFromNow:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *eventDescription __attribute__((swift_name("eventDescription")));
@property (readonly) NSString *eventLocation __attribute__((swift_name("eventLocation")));
@property (readonly) NSString *eventName __attribute__((swift_name("eventName")));
@property (readonly) int64_t msFromNow __attribute__((swift_name("msFromNow")));
@property (readonly) NSArray<KmpEssentialsEventParticipants *> * _Nullable participants __attribute__((swift_name("participants")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EventParticipants")))
@interface KmpEssentialsEventParticipants : KmpEssentialsBase
- (instancetype)initWithEmailAddress:(NSString *)emailAddress firstName:(NSString *)firstName lastName:(NSString *)lastName mobileNumber:(NSString *)mobileNumber __attribute__((swift_name("init(emailAddress:firstName:lastName:mobileNumber:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsEventParticipants *)doCopyEmailAddress:(NSString *)emailAddress firstName:(NSString *)firstName lastName:(NSString *)lastName mobileNumber:(NSString *)mobileNumber __attribute__((swift_name("doCopy(emailAddress:firstName:lastName:mobileNumber:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *emailAddress __attribute__((swift_name("emailAddress")));
@property (readonly) NSString *firstName __attribute__((swift_name("firstName")));
@property (readonly) NSString *lastName __attribute__((swift_name("lastName")));
@property (readonly) NSString *mobileNumber __attribute__((swift_name("mobileNumber")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpCamera")))
@interface KmpEssentialsKmpCamera : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpCameraCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpCamera.Companion")))
@interface KmpEssentialsKmpCameraCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpCameraCompanion *shared __attribute__((swift_name("shared")));
- (void)capturePhotoActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("capturePhoto(actionResult:)")));
- (void)captureVideoActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("captureVideo(actionResult:)")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpClipboard")))
@interface KmpEssentialsKmpClipboard : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpClipboardCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpClipboard.Companion")))
@interface KmpEssentialsKmpClipboardCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpClipboardCompanion *shared __attribute__((swift_name("shared")));
- (void)doCopyTextIntoClipboardTextToCopy:(NSString *)textToCopy __attribute__((swift_name("doCopyTextIntoClipboard(textToCopy:)")));
- (NSString *)getTextFromClipboard __attribute__((swift_name("getTextFromClipboard()")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpConnectivity")))
@interface KmpEssentialsKmpConnectivity : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpConnectivityCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpConnectivity.Companion")))
@interface KmpEssentialsKmpConnectivityCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpConnectivityCompanion *shared __attribute__((swift_name("shared")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getCurrentNetworkIPv4WithCompletionHandler:(void (^)(NSString * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("getCurrentNetworkIPv4(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)getCurrentNetworkIPv6WithCompletionHandler:(void (^)(NSString * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("getCurrentNetworkIPv6(completionHandler:)")));
- (NSString * _Nullable)getCurrentNetworkName __attribute__((swift_name("getCurrentNetworkName()")));
- (BOOL)isConnected __attribute__((swift_name("isConnected()")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)listenToConnectionChangeConnectionState:(void (^)(KmpEssentialsBoolean *))connectionState completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("listenToConnectionChange(connectionState:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Contact")))
@interface KmpEssentialsContact : KmpEssentialsBase
- (instancetype)initWithId:(NSString *)id namePrefix:(NSString *)namePrefix givenName:(NSString *)givenName middleName:(NSString *)middleName familyName:(NSString *)familyName nameSuffix:(NSString *)nameSuffix phoneNumbers:(NSArray<NSString *> *)phoneNumbers emails:(NSArray<NSString *> *)emails displayName:(NSString *)displayName __attribute__((swift_name("init(id:namePrefix:givenName:middleName:familyName:nameSuffix:phoneNumbers:emails:displayName:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsContact *)doCopyId:(NSString *)id namePrefix:(NSString *)namePrefix givenName:(NSString *)givenName middleName:(NSString *)middleName familyName:(NSString *)familyName nameSuffix:(NSString *)nameSuffix phoneNumbers:(NSArray<NSString *> *)phoneNumbers emails:(NSArray<NSString *> *)emails displayName:(NSString *)displayName __attribute__((swift_name("doCopy(id:namePrefix:givenName:middleName:familyName:nameSuffix:phoneNumbers:emails:displayName:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *displayName __attribute__((swift_name("displayName")));
@property (readonly) NSArray<NSString *> *emails __attribute__((swift_name("emails")));
@property (readonly) NSString *familyName __attribute__((swift_name("familyName")));
@property (readonly) NSString *givenName __attribute__((swift_name("givenName")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) NSString *middleName __attribute__((swift_name("middleName")));
@property (readonly) NSString *namePrefix __attribute__((swift_name("namePrefix")));
@property (readonly) NSString *nameSuffix __attribute__((swift_name("nameSuffix")));
@property (readonly) NSArray<NSString *> *phoneNumbers __attribute__((swift_name("phoneNumbers")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpContacts")))
@interface KmpEssentialsKmpContacts : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpContactsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpContacts.Companion")))
@interface KmpEssentialsKmpContactsCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpContactsCompanion *shared __attribute__((swift_name("shared")));
- (void)getAllContactsContactsResponse:(void (^)(NSArray<KmpEssentialsContact *> * _Nullable))contactsResponse __attribute__((swift_name("getAllContacts(contactsResponse:)")));
- (void)pickContactContactsResponse:(void (^)(KmpEssentialsContact * _Nullable))contactsResponse __attribute__((swift_name("pickContact(contactsResponse:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceDisplay")))
@interface KmpEssentialsKmpDeviceDisplay : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpDeviceDisplayCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceDisplay.Companion")))
@interface KmpEssentialsKmpDeviceDisplayCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpDeviceDisplayCompanion *shared __attribute__((swift_name("shared")));
- (void)adjustScreenBrightnessBrightness:(double)brightness __attribute__((swift_name("adjustScreenBrightness(brightness:)")));
- (void)disableScreenOnActive __attribute__((swift_name("disableScreenOnActive()")));
- (void)keepScreenOnActive __attribute__((swift_name("keepScreenOnActive()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DevicePlatform")))
@interface KmpEssentialsDevicePlatform : KmpEssentialsKotlinEnum<KmpEssentialsDevicePlatform *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsDevicePlatform *ios __attribute__((swift_name("ios")));
@property (class, readonly) KmpEssentialsDevicePlatform *android __attribute__((swift_name("android")));
@property (class, readonly) KmpEssentialsDevicePlatform *windows __attribute__((swift_name("windows")));
@property (class, readonly) KmpEssentialsDevicePlatform *macos __attribute__((swift_name("macos")));
@property (class, readonly) KmpEssentialsDevicePlatform *linux __attribute__((swift_name("linux")));
@property (class, readonly) KmpEssentialsDevicePlatform *tizen __attribute__((swift_name("tizen")));
@property (class, readonly) KmpEssentialsDevicePlatform *applewatch __attribute__((swift_name("applewatch")));
@property (class, readonly) KmpEssentialsDevicePlatform *unknown __attribute__((swift_name("unknown")));
+ (KmpEssentialsKotlinArray<KmpEssentialsDevicePlatform *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsDevicePlatform *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DeviceSpecs")))
@interface KmpEssentialsDeviceSpecs : KmpEssentialsBase
- (instancetype)initWithDeviceModel:(NSString *)deviceModel systemVersion:(NSString *)systemVersion manufacturer:(NSString *)manufacturer __attribute__((swift_name("init(deviceModel:systemVersion:manufacturer:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsDeviceSpecs *)doCopyDeviceModel:(NSString *)deviceModel systemVersion:(NSString *)systemVersion manufacturer:(NSString *)manufacturer __attribute__((swift_name("doCopy(deviceModel:systemVersion:manufacturer:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *deviceModel __attribute__((swift_name("deviceModel")));
@property (readonly) NSString *manufacturer __attribute__((swift_name("manufacturer")));
@property (readonly) NSString *systemVersion __attribute__((swift_name("systemVersion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DeviceType")))
@interface KmpEssentialsDeviceType : KmpEssentialsKotlinEnum<KmpEssentialsDeviceType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsDeviceType *virtual_ __attribute__((swift_name("virtual_")));
@property (class, readonly) KmpEssentialsDeviceType *physical __attribute__((swift_name("physical")));
@property (class, readonly) KmpEssentialsDeviceType *unknown __attribute__((swift_name("unknown")));
+ (KmpEssentialsKotlinArray<KmpEssentialsDeviceType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsDeviceType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceInfo")))
@interface KmpEssentialsKmpDeviceInfo : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpDeviceInfoCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceInfo.Companion")))
@interface KmpEssentialsKmpDeviceInfoCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpDeviceInfoCompanion *shared __attribute__((swift_name("shared")));
- (KmpEssentialsDeviceSpecs *)getDeviceSpecs __attribute__((swift_name("getDeviceSpecs()")));
- (NSString *)getDeviceTimeZone __attribute__((swift_name("getDeviceTimeZone()")));
- (KmpEssentialsDevicePlatform *)getRunningPlatform __attribute__((swift_name("getRunningPlatform()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpEmail")))
@interface KmpEssentialsKmpEmail : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpEmailCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpEmail.Companion")))
@interface KmpEssentialsKmpEmailCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpEmailCompanion *shared __attribute__((swift_name("shared")));
- (void)isEmailSupportedAction:(void (^)(KmpEssentialsBoolean *))action __attribute__((swift_name("isEmailSupported(action:)")));
- (void)sendEmailToAddressAddress:(NSString *)address emailSubject:(NSString *)emailSubject emailMessage:(NSString *)emailMessage __attribute__((swift_name("sendEmailToAddress(address:emailSubject:emailMessage:)")));
- (void)sendEmailsToCCAddressAddress:(NSString *)address ccAddresses:(KmpEssentialsKotlinArray<NSString *> * _Nullable)ccAddresses emailSubject:(NSString *)emailSubject emailMessage:(NSString *)emailMessage __attribute__((swift_name("sendEmailsToCCAddress(address:ccAddresses:emailSubject:emailMessage:)")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("EmailReceipientDelegate")))
@interface KmpEssentialsEmailReceipientDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("File")))
@interface KmpEssentialsFile : KmpEssentialsBase
- (instancetype)initWithName:(NSString *)name absolutePath:(NSString *)absolutePath isProtected:(BOOL)isProtected modifiedISO:(NSString *)modifiedISO createdISO:(NSString *)createdISO __attribute__((swift_name("init(name:absolutePath:isProtected:modifiedISO:createdISO:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsFile *)doCopyName:(NSString *)name absolutePath:(NSString *)absolutePath isProtected:(BOOL)isProtected modifiedISO:(NSString *)modifiedISO createdISO:(NSString *)createdISO __attribute__((swift_name("doCopy(name:absolutePath:isProtected:modifiedISO:createdISO:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *absolutePath __attribute__((swift_name("absolutePath")));
@property (readonly) NSString *createdISO __attribute__((swift_name("createdISO")));
@property (readonly) BOOL isProtected __attribute__((swift_name("isProtected")));
@property (readonly) NSString *modifiedISO __attribute__((swift_name("modifiedISO")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFilePicker")))
@interface KmpEssentialsKmpFilePicker : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpFilePickerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFilePicker.Companion")))
@interface KmpEssentialsKmpFilePickerCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpFilePickerCompanion *shared __attribute__((swift_name("shared")));
- (void)getFileFromPickerAction:(void (^)(KmpEssentialsFile * _Nullable))action __attribute__((swift_name("getFileFromPicker(action:)")));
- (void)getMultipleFilesFromPickerActions:(void (^)(NSArray<KmpEssentialsFile *> * _Nullable))actions __attribute__((swift_name("getMultipleFilesFromPicker(actions:)")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("DocumentManyPickerDelegate")))
@interface KmpEssentialsDocumentManyPickerDelegate : NSObject
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("DocumentPickerDelegate")))
@interface KmpEssentialsDocumentPickerDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFileSystem")))
@interface KmpEssentialsKmpFileSystem : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpFileSystemCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFileSystem.Companion")))
@interface KmpEssentialsKmpFileSystemCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpFileSystemCompanion *shared __attribute__((swift_name("shared")));
- (NSString *)createDirectNameAtAppStorageDirectoryName:(NSString *)directoryName __attribute__((swift_name("createDirectNameAtAppStorage(directoryName:)")));
- (void)createFileAtPath:(NSString *)path __attribute__((swift_name("createFileAt(path:)")));
- (void)deleteFileAtPath:(NSString *)path __attribute__((swift_name("deleteFileAt(path:)")));
- (NSArray<NSString *> *)getAllFilePathsFromDirectoryPathDirectoryPath:(NSString *)directoryPath __attribute__((swift_name("getAllFilePathsFromDirectoryPath(directoryPath:)")));
- (NSString *)getAppDirectory __attribute__((swift_name("getAppDirectory()")));
- (NSString *)getExternalStorageDirectory __attribute__((swift_name("getExternalStorageDirectory()")));
- (NSString * _Nullable)getMergedFilePathFromDirectoryDirectoryPath:(NSString *)directoryPath fileName:(NSString *)fileName __attribute__((swift_name("getMergedFilePathFromDirectory(directoryPath:fileName:)")));
- (NSString *)getTempCacheDirectory __attribute__((swift_name("getTempCacheDirectory()")));
- (void)listenToChangesToFileAtPath:(NSString *)path events:(void (^)(NSString *))events __attribute__((swift_name("listenToChangesToFileAt(path:events:)")));
- (NSString * _Nullable)readTextFromFileAtFilePath:(NSString *)filePath __attribute__((swift_name("readTextFromFileAt(filePath:)")));
- (BOOL)wipeAllFilesFromDirectoryPathDirectoryPath:(NSString *)directoryPath __attribute__((swift_name("wipeAllFilesFromDirectoryPath(directoryPath:)")));
- (BOOL)writeTextToFileAtFilePath:(NSString *)filePath content:(NSString *)content __attribute__((swift_name("writeTextToFileAt(filePath:content:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FlashLightMode")))
@interface KmpEssentialsFlashLightMode : KmpEssentialsKotlinEnum<KmpEssentialsFlashLightMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsFlashLightMode *low __attribute__((swift_name("low")));
@property (class, readonly) KmpEssentialsFlashLightMode *medium __attribute__((swift_name("medium")));
@property (class, readonly) KmpEssentialsFlashLightMode *high __attribute__((swift_name("high")));
@property (class, readonly) KmpEssentialsFlashLightMode *max __attribute__((swift_name("max")));
@property (class, readonly) KmpEssentialsFlashLightMode *default_ __attribute__((swift_name("default_")));
+ (KmpEssentialsKotlinArray<KmpEssentialsFlashLightMode *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsFlashLightMode *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFlashlight")))
@interface KmpEssentialsKmpFlashlight : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpFlashlightCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFlashlight.Companion")))
@interface KmpEssentialsKmpFlashlightCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpFlashlightCompanion *shared __attribute__((swift_name("shared")));
- (void)turnOffFlashlight __attribute__((swift_name("turnOffFlashlight()")));
- (void)turnOnFlashLightWithAdjustableStrengthStrengthLevel:(KmpEssentialsFlashLightMode *)strengthLevel __attribute__((swift_name("turnOnFlashLightWithAdjustableStrength(strengthLevel:)")));
- (void)turnOnFlashlight __attribute__((swift_name("turnOnFlashlight()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGeolocation")))
@interface KmpEssentialsKmpGeolocation : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpGeolocationCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGeolocation.Companion")))
@interface KmpEssentialsKmpGeolocationCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpGeolocationCompanion *shared __attribute__((swift_name("shared")));
- (void)getCurrentLocationLocationCoord:(void (^)(KmpEssentialsLocation *))locationCoord __attribute__((swift_name("getCurrentLocation(locationCoord:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Location")))
@interface KmpEssentialsLocation : KmpEssentialsBase
- (instancetype)initWithLatitude:(double)latitude longitude:(double)longitude __attribute__((swift_name("init(latitude:longitude:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsLocation *)doCopyLatitude:(double)latitude longitude:(double)longitude __attribute__((swift_name("doCopy(latitude:longitude:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) double latitude __attribute__((swift_name("latitude")));
@property (readonly) double longitude __attribute__((swift_name("longitude")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGyroscope")))
@interface KmpEssentialsKmpGyroscope : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpGyroscopeCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGyroscope.Companion")))
@interface KmpEssentialsKmpGyroscopeCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpGyroscopeCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningGyroScopeVal:(void (^)(KmpEssentialsKotlinTriple<KmpEssentialsFloat *, KmpEssentialsFloat *, KmpEssentialsFloat *> *))gyroScopeVal __attribute__((swift_name("startListening(gyroScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Mimes")))
@interface KmpEssentialsMimes : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)mimes __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsMimes *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *apng __attribute__((swift_name("apng")));
@property (readonly) NSString *csv __attribute__((swift_name("csv")));
@property (readonly) NSString *jpeg __attribute__((swift_name("jpeg")));
@property (readonly) NSString *json __attribute__((swift_name("json")));
@property (readonly) NSString *pdf __attribute__((swift_name("pdf")));
@property (readonly) NSString *plainText __attribute__((swift_name("plainText")));
@property (readonly) NSString *png __attribute__((swift_name("png")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLauncher")))
@interface KmpEssentialsKmpLauncher : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpLauncherCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLauncher.Companion")))
@interface KmpEssentialsKmpLauncherCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpLauncherCompanion *shared __attribute__((swift_name("shared")));
- (void)launchAppInternalSettings __attribute__((swift_name("launchAppInternalSettings()")));
- (void)launchAppStoreViaIdentifierAppStoreLink:(NSString *)appStoreLink __attribute__((swift_name("launchAppStoreViaIdentifier(appStoreLink:)")));
- (void)launchExternalMapsAppWithAddressAddress:(NSString *)address markerTitle:(NSString *)markerTitle __attribute__((swift_name("launchExternalMapsAppWithAddress(address:markerTitle:)")));
- (void)launchExternalMapsAppWithCoordinatesLatitude:(double)latitude longitude:(double)longitude markerTitle:(NSString *)markerTitle __attribute__((swift_name("launchExternalMapsAppWithCoordinates(latitude:longitude:markerTitle:)")));
- (void)launchExternalUrlViaAnyAppLinkPath:(NSString *)linkPath __attribute__((swift_name("launchExternalUrlViaAnyApp(linkPath:)")));
- (void)launchExternalUrlViaBrowserLinkPath:(NSString *)linkPath __attribute__((swift_name("launchExternalUrlViaBrowser(linkPath:)")));
- (void)startTimerSeconds:(double)seconds action:(KmpEssentialsBoolean *(^)(void))action __attribute__((swift_name("startTimer(seconds:action:)")));
- (void)startTimerRepeatingSeconds:(double)seconds action:(KmpEssentialsBoolean *(^)(void))action __attribute__((swift_name("startTimerRepeating(seconds:action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLifecycle")))
@interface KmpEssentialsKmpLifecycle : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpLifecycleCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLifecycle.Companion")))
@interface KmpEssentialsKmpLifecycleCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpLifecycleCompanion *shared __attribute__((swift_name("shared")));
- (void)resetAppLifecycleActions __attribute__((swift_name("resetAppLifecycleActions()")));
- (void)setAppLifecycleBackgroundAction:(void (^)(void))action __attribute__((swift_name("setAppLifecycleBackground(action:)")));
- (void)setAppLifecycleForegroundAction:(void (^)(void))action __attribute__((swift_name("setAppLifecycleForeground(action:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)waitForAppToReturnToForegroundAction:(id<KmpEssentialsKotlinSuspendFunction0>)action completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("waitForAppToReturnToForeground(action:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLocalNotifications")))
@interface KmpEssentialsKmpLocalNotifications : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpLocalNotificationsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLocalNotifications.Companion")))
@interface KmpEssentialsKmpLocalNotificationsCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpLocalNotificationsCompanion *shared __attribute__((swift_name("shared")));
- (void)cancelAlarmWithIdAlarmId:(NSString *)alarmId __attribute__((swift_name("cancelAlarmWithId(alarmId:)")));
- (void)cancelAllAlarms __attribute__((swift_name("cancelAllAlarms()")));
- (BOOL)isSchedulingAlarmWithIdAlarmId:(NSString *)alarmId __attribute__((swift_name("isSchedulingAlarmWithId(alarmId:)")));
- (NSString *)scheduleAlarmNotificationDurationMS:(int64_t)durationMS title:(NSString *)title message:(NSString *)message __attribute__((swift_name("scheduleAlarmNotification(durationMS:title:message:)")));
- (NSString *)scheduleAlarmNotificationRepeatingDurationMS:(int64_t)durationMS intervalMs:(int64_t)intervalMs title:(NSString *)title message:(NSString *)message __attribute__((swift_name("scheduleAlarmNotificationRepeating(durationMS:intervalMs:title:message:)")));
- (void)sendNotificationTitle:(NSString *)title message:(NSString *)message __attribute__((swift_name("sendNotification(title:message:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLogging")))
@interface KmpEssentialsKmpLogging : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpLoggingCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLogging.Companion")))
@interface KmpEssentialsKmpLoggingCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpLoggingCompanion *shared __attribute__((swift_name("shared")));
- (void)writeErrorTag:(NSString *)tag message:(NSString *)message __attribute__((swift_name("writeError(tag:message:)")));
- (void)writeErrorWithCodeErrorCode:(NSString *)errorCode __attribute__((swift_name("writeErrorWithCode(errorCode:)")));
- (void)writeExceptionTag:(NSString *)tag exception:(KmpEssentialsKotlinException *)exception __attribute__((swift_name("writeException(tag:exception:)")));
- (void)writeInfoTag:(NSString *)tag message:(NSString *)message __attribute__((swift_name("writeInfo(tag:message:)")));
- (void)writeInfoWithCodeErrorCode:(NSString *)errorCode __attribute__((swift_name("writeInfoWithCode(errorCode:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMagnometer")))
@interface KmpEssentialsKmpMagnometer : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpMagnometerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMagnometer.Companion")))
@interface KmpEssentialsKmpMagnometerCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpMagnometerCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningMagScopeVal:(void (^)(KmpEssentialsKotlinTriple<KmpEssentialsFloat *, KmpEssentialsFloat *, KmpEssentialsFloat *> *))magScopeVal __attribute__((swift_name("startListening(magScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMainThread")))
@interface KmpEssentialsKmpMainThread : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpMainThreadCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMainThread.Companion")))
@interface KmpEssentialsKmpMainThreadCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpMainThreadCompanion *shared __attribute__((swift_name("shared")));
- (void)runViaMainThreadAction:(void (^)(void))action __attribute__((swift_name("runViaMainThread(action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMediaPicker")))
@interface KmpEssentialsKmpMediaPicker : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpMediaPickerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMediaPicker.Companion")))
@interface KmpEssentialsKmpMediaPickerCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpMediaPickerCompanion *shared __attribute__((swift_name("shared")));
- (void)pickPhotoFromGalleryActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("pickPhotoFromGallery(actionResult:)")));
- (void)pickVideoFromGalleryActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("pickVideoFromGallery(actionResult:)")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("ImageMediaPickerDelegate")))
@interface KmpEssentialsImageMediaPickerDelegate : NSObject
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("MediaPickerDelegate")))
@interface KmpEssentialsMediaPickerDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpOrientationManager")))
@interface KmpEssentialsKmpOrientationManager : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpOrientationManagerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpOrientationManager.Companion")))
@interface KmpEssentialsKmpOrientationManagerCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpOrientationManagerCompanion *shared __attribute__((swift_name("shared")));
- (KmpEssentialsOrientationState *)getCurrentOrientation __attribute__((swift_name("getCurrentOrientation()")));
- (void)startListeningOrientationChange:(void (^)(KmpEssentialsOrientationState *))orientationChange __attribute__((swift_name("startListening(orientationChange:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("OrientationState")))
@interface KmpEssentialsOrientationState : KmpEssentialsKotlinEnum<KmpEssentialsOrientationState *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsOrientationState *landscape __attribute__((swift_name("landscape")));
@property (class, readonly) KmpEssentialsOrientationState *portrait __attribute__((swift_name("portrait")));
@property (class, readonly) KmpEssentialsOrientationState *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) KmpEssentialsOrientationState *leftwrist __attribute__((swift_name("leftwrist")));
@property (class, readonly) KmpEssentialsOrientationState *rightwrist __attribute__((swift_name("rightwrist")));
+ (KmpEssentialsKotlinArray<KmpEssentialsOrientationState *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsOrientationState *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPermissionsManager")))
@interface KmpEssentialsKmpPermissionsManager : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpPermissionsManagerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPermissionsManager.Companion")))
@interface KmpEssentialsKmpPermissionsManagerCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpPermissionsManagerCompanion *shared __attribute__((swift_name("shared")));
- (void)canShowPromptDialogPermission:(KmpEssentialsPermission *)permission actionResult:(void (^)(KmpEssentialsBoolean *))actionResult __attribute__((swift_name("canShowPromptDialog(permission:actionResult:)")));
- (BOOL)isPermissionGrantedPermission:(KmpEssentialsPermission *)permission __attribute__((swift_name("isPermissionGranted(permission:)")));
- (void)isPermissionGrantedPermission:(KmpEssentialsPermission *)permission actionResult:(void (^)(KmpEssentialsBoolean *))actionResult __attribute__((swift_name("isPermissionGranted(permission:actionResult:)")));
- (void)requestPermissionPermission:(KmpEssentialsPermission *)permission runAction:(void (^)(void))runAction __attribute__((swift_name("requestPermission(permission:runAction:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Permission")))
@interface KmpEssentialsPermission : KmpEssentialsKotlinEnum<KmpEssentialsPermission *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsPermission *camera __attribute__((swift_name("camera")));
@property (class, readonly) KmpEssentialsPermission *flashlight __attribute__((swift_name("flashlight")));
@property (class, readonly) KmpEssentialsPermission *externalstorage __attribute__((swift_name("externalstorage")));
@property (class, readonly) KmpEssentialsPermission *location __attribute__((swift_name("location")));
@property (class, readonly) KmpEssentialsPermission *photogallery __attribute__((swift_name("photogallery")));
@property (class, readonly) KmpEssentialsPermission *speech __attribute__((swift_name("speech")));
@property (class, readonly) KmpEssentialsPermission *coarselocation __attribute__((swift_name("coarselocation")));
@property (class, readonly) KmpEssentialsPermission *sms __attribute__((swift_name("sms")));
@property (class, readonly) KmpEssentialsPermission *microphone __attribute__((swift_name("microphone")));
@property (class, readonly) KmpEssentialsPermission *pushnotifications __attribute__((swift_name("pushnotifications")));
@property (class, readonly) KmpEssentialsPermission *biometrics __attribute__((swift_name("biometrics")));
@property (class, readonly) KmpEssentialsPermission *contacts __attribute__((swift_name("contacts")));
@property (class, readonly) KmpEssentialsPermission *vibrator __attribute__((swift_name("vibrator")));
@property (class, readonly) KmpEssentialsPermission *calendar __attribute__((swift_name("calendar")));
+ (KmpEssentialsKotlinArray<KmpEssentialsPermission *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsPermission *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PermissionStatus")))
@interface KmpEssentialsPermissionStatus : KmpEssentialsKotlinEnum<KmpEssentialsPermissionStatus *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) KmpEssentialsPermissionStatus *granted __attribute__((swift_name("granted")));
@property (class, readonly) KmpEssentialsPermissionStatus *denied __attribute__((swift_name("denied")));
@property (class, readonly) KmpEssentialsPermissionStatus *idle __attribute__((swift_name("idle")));
+ (KmpEssentialsKotlinArray<KmpEssentialsPermissionStatus *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<KmpEssentialsPermissionStatus *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("LocationPermissionsDelegate")))
@interface KmpEssentialsLocationPermissionsDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPrinting")))
@interface KmpEssentialsKmpPrinting : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpPrintingCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPrinting.Companion")))
@interface KmpEssentialsKmpPrintingCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpPrintingCompanion *shared __attribute__((swift_name("shared")));
- (BOOL)isPrintingSupported __attribute__((swift_name("isPrintingSupported()")));
- (void)printDocumentWithPathPath:(NSString *)path __attribute__((swift_name("printDocumentWithPath(path:)")));
- (void)printHtmlWithPathPath:(NSString *)path __attribute__((swift_name("printHtmlWithPath(path:)")));
- (void)printImageWithPathPath:(NSString *)path __attribute__((swift_name("printImageWithPath(path:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpProximity")))
@interface KmpEssentialsKmpProximity : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpProximityCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpProximity.Companion")))
@interface KmpEssentialsKmpProximityCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpProximityCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningProximityScopeVal:(void (^)(KmpEssentialsBoolean *))proximityScopeVal __attribute__((swift_name("startListening(proximityScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPromptReview")))
@interface KmpEssentialsKmpPromptReview : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpPromptReviewCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPromptReview.Companion")))
@interface KmpEssentialsKmpPromptReviewCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpPromptReviewCompanion *shared __attribute__((swift_name("shared")));
- (void)openAppStoreLink __attribute__((swift_name("openAppStoreLink()")));
- (void)promptReviewInAppErrorPromptingDialog:(void (^)(NSString *))errorPromptingDialog actionAfterClosing:(void (^ _Nullable)(void))actionAfterClosing __attribute__((swift_name("promptReviewInApp(errorPromptingDialog:actionAfterClosing:)")));
- (void)promptReviewViaExternal __attribute__((swift_name("promptReviewViaExternal()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpScreenshot")))
@interface KmpEssentialsKmpScreenshot : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpScreenshotCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpScreenshot.Companion")))
@interface KmpEssentialsKmpScreenshotCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpScreenshotCompanion *shared __attribute__((swift_name("shared")));
- (void)getScreenshotAction:(void (^)(NSString *))action shareDialogTitle:(NSString *)shareDialogTitle shareImage:(BOOL)shareImage __attribute__((swift_name("getScreenshot(action:shareDialogTitle:shareImage:)")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPublicStorage")))
@interface KmpEssentialsKmpPublicStorage : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpPublicStorageCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPublicStorage.Companion")))
@interface KmpEssentialsKmpPublicStorageCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpPublicStorageCompanion *shared __attribute__((swift_name("shared")));
- (void)clearEntireStore __attribute__((swift_name("clearEntireStore()")));
- (void)deleteDataForKeyKey:(NSString *)key __attribute__((swift_name("deleteDataForKey(key:)")));
- (KmpEssentialsBoolean * _Nullable)getBooleanFromKeyKey:(NSString *)key __attribute__((swift_name("getBooleanFromKey(key:)")));
- (BOOL)getBooleanFromKeyKey:(NSString *)key defValue:(BOOL)defValue __attribute__((swift_name("getBooleanFromKey(key:defValue:)")));
- (KmpEssentialsDouble * _Nullable)getDoubleFromKeyKey:(NSString *)key __attribute__((swift_name("getDoubleFromKey(key:)")));
- (double)getDoubleFromKeyKey:(NSString *)key defValue:(double)defValue __attribute__((swift_name("getDoubleFromKey(key:defValue:)")));
- (KmpEssentialsFloat * _Nullable)getFloatFromKeyKey:(NSString *)key __attribute__((swift_name("getFloatFromKey(key:)")));
- (float)getFloatFromKeyKey:(NSString *)key defValue:(float)defValue __attribute__((swift_name("getFloatFromKey(key:defValue:)")));
- (KmpEssentialsInt * _Nullable)getIntFromKeyKey:(NSString *)key __attribute__((swift_name("getIntFromKey(key:)")));
- (int32_t)getIntFromKeyKey:(NSString *)key defValue:(int32_t)defValue __attribute__((swift_name("getIntFromKey(key:defValue:)")));
- (KmpEssentialsLong * _Nullable)getLongFromKeyKey:(NSString *)key __attribute__((swift_name("getLongFromKey(key:)")));
- (int64_t)getLongFromKeyKey:(NSString *)key defValue:(int64_t)defValue __attribute__((swift_name("getLongFromKey(key:defValue:)")));
- (NSString * _Nullable)getStringFromKeyKey:(NSString *)key __attribute__((swift_name("getStringFromKey(key:)")));
- (NSString * _Nullable)getStringFromKeyKey:(NSString *)key defValue:(NSString * _Nullable)defValue __attribute__((swift_name("getStringFromKey(key:defValue:)")));
- (void)persistDataKey:(NSString *)key item:(id _Nullable)item __attribute__((swift_name("persistData(key:item:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSecureStorage")))
@interface KmpEssentialsKmpSecureStorage : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpSecureStorageCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSecureStorage.Companion")))
@interface KmpEssentialsKmpSecureStorageCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpSecureStorageCompanion *shared __attribute__((swift_name("shared")));
- (void)clearEntireStore __attribute__((swift_name("clearEntireStore()")));
- (void)configureSecurityForiOSServiceName:(NSString *)serviceName accessGroup:(NSString *)accessGroup __attribute__((swift_name("configureSecurityForiOS(serviceName:accessGroup:)")));
- (void)deleteDataForKeyKey:(NSString *)key __attribute__((swift_name("deleteDataForKey(key:)")));
- (KmpEssentialsBoolean * _Nullable)getBooleanFromKeyKey:(NSString *)key __attribute__((swift_name("getBooleanFromKey(key:)")));
- (KmpEssentialsDouble * _Nullable)getDoubleFromKeyKey:(NSString *)key __attribute__((swift_name("getDoubleFromKey(key:)")));
- (KmpEssentialsFloat * _Nullable)getFloatFromKeyKey:(NSString *)key __attribute__((swift_name("getFloatFromKey(key:)")));
- (KmpEssentialsInt * _Nullable)getIntFromKeyKey:(NSString *)key __attribute__((swift_name("getIntFromKey(key:)")));
- (KmpEssentialsLong * _Nullable)getLongFromKeyKey:(NSString *)key __attribute__((swift_name("getLongFromKey(key:)")));
- (NSString * _Nullable)getStringFromKeyKey:(NSString *)key __attribute__((swift_name("getStringFromKey(key:)")));
- (void)persistDataKey:(NSString *)key item:(id _Nullable)item __attribute__((swift_name("persistData(key:item:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpShare")))
@interface KmpEssentialsKmpShare : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpShareCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpShare.Companion")))
@interface KmpEssentialsKmpShareCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpShareCompanion *shared __attribute__((swift_name("shared")));
- (KmpEssentialsKmpShareCompanion *)setFileTypeCFileType:(NSString *)cFileType __attribute__((swift_name("setFileType(cFileType:)")));
- (void)shareFileWithAnyAppFilePath:(NSString *)filePath optionalTitle:(NSString *)optionalTitle __attribute__((swift_name("shareFileWithAnyApp(filePath:optionalTitle:)")));
- (void)shareTextWithAnyAppText:(NSString *)text optionalTitle:(NSString *)optionalTitle __attribute__((swift_name("shareTextWithAnyApp(text:optionalTitle:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSms")))
@interface KmpEssentialsKmpSms : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpSmsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSms.Companion")))
@interface KmpEssentialsKmpSmsCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpSmsCompanion *shared __attribute__((swift_name("shared")));
- (void)sendSmsToNumberMessage:(NSString *)message mobileNumber:(NSString *)mobileNumber __attribute__((swift_name("sendSmsToNumber(message:mobileNumber:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTelecom")))
@interface KmpEssentialsKmpTelecom : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpTelecomCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTelecom.Companion")))
@interface KmpEssentialsKmpTelecomCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpTelecomCompanion *shared __attribute__((swift_name("shared")));
- (void)launchPhoneCallWithNumberMobileNumber:(NSString *)mobileNumber __attribute__((swift_name("launchPhoneCallWithNumber(mobileNumber:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTextToSpeech")))
@interface KmpEssentialsKmpTextToSpeech : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpTextToSpeechCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTextToSpeech.Companion")))
@interface KmpEssentialsKmpTextToSpeechCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpTextToSpeechCompanion *shared __attribute__((swift_name("shared")));
- (void)convertSpeechToTextResponse:(void (^)(NSString *))response __attribute__((swift_name("convertSpeechToText(response:)")));
- (void)convertTextToSpeechMessage:(NSString *)message __attribute__((swift_name("convertTextToSpeech(message:)")));
- (void)stopSpeechEngine __attribute__((swift_name("stopSpeechEngine()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpToast")))
@interface KmpEssentialsKmpToast : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpToastCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpToast.Companion")))
@interface KmpEssentialsKmpToastCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpToastCompanion *shared __attribute__((swift_name("shared")));
- (void)showToastLongMessage:(NSString *)message __attribute__((swift_name("showToastLong(message:)")));
- (void)showToastShortMessage:(NSString *)message __attribute__((swift_name("showToastShort(message:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpVibration")))
@interface KmpEssentialsKmpVibration : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) KmpEssentialsKmpVibrationCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpVibration.Companion")))
@interface KmpEssentialsKmpVibrationCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKmpVibrationCompanion *shared __attribute__((swift_name("shared")));
- (void)startVibratingDurationMs:(int64_t)durationMs __attribute__((swift_name("startVibrating(durationMs:)")));
- (void)stopVibrating __attribute__((swift_name("stopVibrating()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinTriple")))
@interface KmpEssentialsKotlinTriple<__covariant A, __covariant B, __covariant C> : KmpEssentialsBase
- (instancetype)initWithFirst:(A _Nullable)first second:(B _Nullable)second third:(C _Nullable)third __attribute__((swift_name("init(first:second:third:)"))) __attribute__((objc_designated_initializer));
- (KmpEssentialsKotlinTriple<A, B, C> *)doCopyFirst:(A _Nullable)first second:(B _Nullable)second third:(C _Nullable)third __attribute__((swift_name("doCopy(first:second:third:)")));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@property (readonly) A _Nullable first __attribute__((swift_name("first")));
@property (readonly) B _Nullable second __attribute__((swift_name("second")));
@property (readonly) C _Nullable third __attribute__((swift_name("third")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface KmpEssentialsKotlinEnumCompanion : KmpEssentialsBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) KmpEssentialsKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface KmpEssentialsKotlinArray<T> : KmpEssentialsBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(KmpEssentialsInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<KmpEssentialsKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("KotlinFunction")))
@protocol KmpEssentialsKotlinFunction
@required
@end

__attribute__((swift_name("KotlinSuspendFunction0")))
@protocol KmpEssentialsKotlinSuspendFunction0 <KmpEssentialsKotlinFunction>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeWithCompletionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(completionHandler:)")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface KmpEssentialsKotlinThrowable : KmpEssentialsBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (KmpEssentialsKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) KmpEssentialsKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface KmpEssentialsKotlinException : KmpEssentialsKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface KmpEssentialsKotlinRuntimeException : KmpEssentialsKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface KmpEssentialsKotlinIllegalStateException : KmpEssentialsKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface KmpEssentialsKotlinCancellationException : KmpEssentialsKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KmpEssentialsKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol KmpEssentialsKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
