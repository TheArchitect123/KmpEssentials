#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class SharedKmpiOS, UIViewController, CMMotionManager, SharedKmpAccelerometerCompanion, SharedKotlinTriple<__covariant A, __covariant B, __covariant C>, SharedKmpAlertCompanion, SharedKmpAppActionsCompanion, SharedKotlinEnumCompanion, SharedKotlinEnum<E>, SharedAppDeviceTheme, SharedKotlinArray<T>, SharedKmpAppInfoCompanion, SharedKmpAudioCompanion, SharedKmpBackButtonCompanion, SharedBackgroundOptions, SharedKmpBackgroundingCompanion, SharedKmpForegroundServiceCompanion, SharedKmpBatteryCompanion, SharedBatteryChargeState, SharedBatteryPowerSource, SharedBatteryHealth, SharedEnergySaverStatus, SharedKmpBiometricsCompanion, SharedKmpCalendarCompanion, SharedCalendarInfo, SharedEventParticipants, SharedKmpCameraCompanion, SharedKmpClipboardCompanion, SharedKmpConnectivityCompanion, SharedContact, SharedKmpContactsCompanion, SharedKmpDeviceDisplayCompanion, SharedDevicePlatform, SharedDeviceSpecs, SharedDeviceType, SharedKmpDeviceInfoCompanion, SharedKmpEmailCompanion, SharedFile, SharedKmpFilePickerCompanion, SharedKmpFileSystemCompanion, SharedFlashLightMode, SharedKmpFlashlightCompanion, SharedKmpGeolocationCompanion, SharedLocation, SharedKmpGyroscopeCompanion, SharedMimes, SharedKmpLauncherCompanion, SharedKmpLifecycleCompanion, SharedKmpLocalNotificationsCompanion, SharedKmpLoggingCompanion, SharedKotlinException, SharedKmpMagnometerCompanion, SharedKmpMainThreadCompanion, SharedKmpMediaPickerCompanion, SharedKmpOrientationManagerCompanion, SharedOrientationState, SharedKmpPermissionsManagerCompanion, SharedPermission, SharedPermissionStatus, SharedKmpPrintingCompanion, SharedKmpProximityCompanion, SharedKmpPromptReviewCompanion, SharedKmpScreenshotCompanion, SharedKmpPublicStorageCompanion, SharedKmpSecureStorageCompanion, SharedKmpShareCompanion, SharedKmpSmsCompanion, SharedKmpTelecomCompanion, SharedKmpTextToSpeechCompanion, SharedKmpToastCompanion, SharedKmpVibrationCompanion, SharedKotlinThrowable, SharedKotlinRuntimeException, SharedKotlinIllegalStateException;

@protocol SharedKotlinComparable, SharedKotlinSuspendFunction0, SharedKotlinIterator, SharedKotlinFunction;

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
@interface SharedBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface SharedBase (SharedBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface SharedMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface SharedMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorSharedKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface SharedNumber : NSNumber
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
@interface SharedByte : SharedNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface SharedUByte : SharedNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface SharedShort : SharedNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface SharedUShort : SharedNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface SharedInt : SharedNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface SharedUInt : SharedNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface SharedLong : SharedNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface SharedULong : SharedNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface SharedFloat : SharedNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface SharedDouble : SharedNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface SharedBoolean : SharedNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpiOS")))
@interface SharedKmpiOS : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)kmpiOS __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpiOS *shared __attribute__((swift_name("shared")));
- (UIViewController * _Nullable)getTopViewController __attribute__((swift_name("getTopViewController()")));
@property (readonly) CMMotionManager *motionManager __attribute__((swift_name("motionManager")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAccelerometer")))
@interface SharedKmpAccelerometer : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpAccelerometerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAccelerometer.Companion")))
@interface SharedKmpAccelerometerCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpAccelerometerCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningAccScopeVal:(void (^)(SharedKotlinTriple<SharedFloat *, SharedFloat *, SharedFloat *> *))accScopeVal __attribute__((swift_name("startListening(accScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAlert")))
@interface SharedKmpAlert : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpAlertCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAlert.Companion")))
@interface SharedKmpAlertCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpAlertCompanion *shared __attribute__((swift_name("shared")));
- (void)showAlertMessage:(NSString *)message title:(NSString *)title __attribute__((swift_name("showAlert(message:title:)")));
- (void)showAlertMessage:(NSString *)message title:(NSString *)title okText:(NSString *)okText okAction:(void (^)(void))okAction __attribute__((swift_name("showAlert(message:title:okText:okAction:)")));
- (void)showAlertWithConfirmationMessage:(NSString *)message title:(NSString *)title okText:(NSString *)okText cancelText:(NSString *)cancelText okAction:(void (^)(void))okAction cancelAction:(void (^)(void))cancelAction __attribute__((swift_name("showAlertWithConfirmation(message:title:okText:cancelText:okAction:cancelAction:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppActions")))
@interface SharedKmpAppActions : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpAppActionsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppActions.Companion")))
@interface SharedKmpAppActionsCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpAppActionsCompanion *shared __attribute__((swift_name("shared")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((swift_name("KotlinComparable")))
@protocol SharedKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface SharedKotlinEnum<E> : SharedBase <SharedKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AppDeviceTheme")))
@interface SharedAppDeviceTheme : SharedKotlinEnum<SharedAppDeviceTheme *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedAppDeviceTheme *dark __attribute__((swift_name("dark")));
@property (class, readonly) SharedAppDeviceTheme *light __attribute__((swift_name("light")));
@property (class, readonly) SharedAppDeviceTheme *system __attribute__((swift_name("system")));
+ (SharedKotlinArray<SharedAppDeviceTheme *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedAppDeviceTheme *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppInfo")))
@interface SharedKmpAppInfo : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpAppInfoCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAppInfo.Companion")))
@interface SharedKmpAppInfoCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpAppInfoCompanion *shared __attribute__((swift_name("shared")));
- (int32_t)getPackageMinOS __attribute__((swift_name("getPackageMinOS()")));
- (NSString *)getPackageName __attribute__((swift_name("getPackageName()")));
- (NSString *)getPackageVersion __attribute__((swift_name("getPackageVersion()")));
- (int32_t)getPackageVersionCode __attribute__((swift_name("getPackageVersionCode()")));
- (SharedAppDeviceTheme *)getSystemThemeMode __attribute__((swift_name("getSystemThemeMode()")));
- (void)isRunningInBackgroundAction:(void (^)(SharedBoolean *))action __attribute__((swift_name("isRunningInBackground(action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAudio")))
@interface SharedKmpAudio : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpAudioCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpAudio.Companion")))
@interface SharedKmpAudioCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpAudioCompanion *shared __attribute__((swift_name("shared")));
- (void)playAudioFileWithPathFilePath:(NSString *)filePath __attribute__((swift_name("playAudioFileWithPath(filePath:)")));
- (void)recordVoiceAndReturnFilePathActionParams:(void (^)(NSString *))actionParams __attribute__((swift_name("recordVoiceAndReturnFilePath(actionParams:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackButton")))
@interface SharedKmpBackButton : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpBackButtonCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackButton.Companion")))
@interface SharedKmpBackButtonCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpBackButtonCompanion *shared __attribute__((swift_name("shared")));
- (void)disableBackButton __attribute__((swift_name("disableBackButton()")));
- (void)disableBackButtonOverrideWithCustomActionCustomAction:(void (^)(void))customAction __attribute__((swift_name("disableBackButtonOverrideWithCustomAction(customAction:)")));
- (void)enableBackButton __attribute__((swift_name("enableBackButton()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BackgroundOptions")))
@interface SharedBackgroundOptions : SharedBase
- (instancetype)initWithRequiresInternet:(BOOL)requiresInternet requiresStorage:(BOOL)requiresStorage requiresSufficientBattery:(BOOL)requiresSufficientBattery __attribute__((swift_name("init(requiresInternet:requiresStorage:requiresSufficientBattery:)"))) __attribute__((objc_designated_initializer));
- (SharedBackgroundOptions *)doCopyRequiresInternet:(BOOL)requiresInternet requiresStorage:(BOOL)requiresStorage requiresSufficientBattery:(BOOL)requiresSufficientBattery __attribute__((swift_name("doCopy(requiresInternet:requiresStorage:requiresSufficientBattery:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL requiresInternet __attribute__((swift_name("requiresInternet")));
@property (readonly) BOOL requiresStorage __attribute__((swift_name("requiresStorage")));
@property (readonly) BOOL requiresSufficientBattery __attribute__((swift_name("requiresSufficientBattery")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackgrounding")))
@interface SharedKmpBackgrounding : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpBackgroundingCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBackgrounding.Companion")))
@interface SharedKmpBackgroundingCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpBackgroundingCompanion *shared __attribute__((swift_name("shared")));
- (void)cancelAllRunningWorkers __attribute__((swift_name("cancelAllRunningWorkers()")));
- (void)createAndStartForegroundWorkerTitle:(NSString *)title message:(NSString *)message action:(id<SharedKotlinSuspendFunction0>)action __attribute__((swift_name("createAndStartForegroundWorker(title:message:action:)")));
- (void)createAndStartWorkerOptions:(SharedBackgroundOptions * _Nullable)options action:(id<SharedKotlinSuspendFunction0>)action __attribute__((swift_name("createAndStartWorker(options:action:)")));
- (void)createAndStartWorkerWithoutCancelOptions:(SharedBackgroundOptions * _Nullable)options action:(id<SharedKotlinSuspendFunction0>)action __attribute__((swift_name("createAndStartWorkerWithoutCancel(options:action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpForegroundService")))
@interface SharedKmpForegroundService : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpForegroundServiceCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpForegroundService.Companion")))
@interface SharedKmpForegroundServiceCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpForegroundServiceCompanion *shared __attribute__((swift_name("shared")));
- (void)registerBackgroundService __attribute__((swift_name("registerBackgroundService()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBattery")))
@interface SharedKmpBattery : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpBatteryCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBattery.Companion")))
@interface SharedKmpBatteryCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpBatteryCompanion *shared __attribute__((swift_name("shared")));
- (int64_t)getCurrentChargeLevel __attribute__((swift_name("getCurrentChargeLevel()")));
- (SharedBatteryChargeState *)getCurrentChargeState __attribute__((swift_name("getCurrentChargeState()")));
- (SharedBatteryPowerSource *)getCurrentPowerSource __attribute__((swift_name("getCurrentPowerSource()")));
- (BOOL)isEnergySaverOn __attribute__((swift_name("isEnergySaverOn()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BatteryChargeState")))
@interface SharedBatteryChargeState : SharedKotlinEnum<SharedBatteryChargeState *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedBatteryChargeState *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) SharedBatteryChargeState *charging __attribute__((swift_name("charging")));
@property (class, readonly) SharedBatteryChargeState *discharging __attribute__((swift_name("discharging")));
@property (class, readonly) SharedBatteryChargeState *full __attribute__((swift_name("full")));
@property (class, readonly) SharedBatteryChargeState *notcharging __attribute__((swift_name("notcharging")));
@property (class, readonly) SharedBatteryChargeState *notpresent __attribute__((swift_name("notpresent")));
+ (SharedKotlinArray<SharedBatteryChargeState *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedBatteryChargeState *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BatteryHealth")))
@interface SharedBatteryHealth : SharedKotlinEnum<SharedBatteryHealth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedBatteryHealth *cold __attribute__((swift_name("cold")));
@property (class, readonly) SharedBatteryHealth *dead __attribute__((swift_name("dead")));
@property (class, readonly) SharedBatteryHealth *good __attribute__((swift_name("good")));
@property (class, readonly) SharedBatteryHealth *overheat __attribute__((swift_name("overheat")));
@property (class, readonly) SharedBatteryHealth *overcharge __attribute__((swift_name("overcharge")));
@property (class, readonly) SharedBatteryHealth *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) SharedBatteryHealth *failure __attribute__((swift_name("failure")));
+ (SharedKotlinArray<SharedBatteryHealth *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedBatteryHealth *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BatteryPowerSource")))
@interface SharedBatteryPowerSource : SharedKotlinEnum<SharedBatteryPowerSource *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedBatteryPowerSource *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) SharedBatteryPowerSource *battery __attribute__((swift_name("battery")));
@property (class, readonly) SharedBatteryPowerSource *ac __attribute__((swift_name("ac")));
@property (class, readonly) SharedBatteryPowerSource *usb __attribute__((swift_name("usb")));
@property (class, readonly) SharedBatteryPowerSource *wireless __attribute__((swift_name("wireless")));
+ (SharedKotlinArray<SharedBatteryPowerSource *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedBatteryPowerSource *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EnergySaverStatus")))
@interface SharedEnergySaverStatus : SharedKotlinEnum<SharedEnergySaverStatus *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedEnergySaverStatus *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) SharedEnergySaverStatus *on __attribute__((swift_name("on")));
@property (class, readonly) SharedEnergySaverStatus *off __attribute__((swift_name("off")));
+ (SharedKotlinArray<SharedEnergySaverStatus *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedEnergySaverStatus *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBiometrics")))
@interface SharedKmpBiometrics : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpBiometricsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpBiometrics.Companion")))
@interface SharedKmpBiometricsCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpBiometricsCompanion *shared __attribute__((swift_name("shared")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
- (void)scanBiometricsActionResult:(void (^)(SharedBoolean *))actionResult actionError:(void (^)(NSString *))actionError __attribute__((swift_name("scanBiometrics(actionResult:actionError:)")));
- (void)setPromptInfoTitle:(NSString *)title message:(NSString *)message __attribute__((swift_name("setPromptInfo(title:message:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpCalendar")))
@interface SharedKmpCalendar : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpCalendarCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpCalendar.Companion")))
@interface SharedKmpCalendarCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpCalendarCompanion *shared __attribute__((swift_name("shared")));
- (NSString *)addCalendarEventEventInfo:(SharedCalendarInfo *)eventInfo __attribute__((swift_name("addCalendarEvent(eventInfo:)")));
- (BOOL)removeCalendarEventEventId:(NSString *)eventId __attribute__((swift_name("removeCalendarEvent(eventId:)")));
- (NSString *)updateCalendarEventEventId:(NSString *)eventId eventInfo:(SharedCalendarInfo *)eventInfo __attribute__((swift_name("updateCalendarEvent(eventId:eventInfo:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CalendarInfo")))
@interface SharedCalendarInfo : SharedBase
- (instancetype)initWithEventName:(NSString *)eventName eventDescription:(NSString *)eventDescription eventLocation:(NSString *)eventLocation participants:(NSArray<SharedEventParticipants *> * _Nullable)participants msFromNow:(int64_t)msFromNow __attribute__((swift_name("init(eventName:eventDescription:eventLocation:participants:msFromNow:)"))) __attribute__((objc_designated_initializer));
- (SharedCalendarInfo *)doCopyEventName:(NSString *)eventName eventDescription:(NSString *)eventDescription eventLocation:(NSString *)eventLocation participants:(NSArray<SharedEventParticipants *> * _Nullable)participants msFromNow:(int64_t)msFromNow __attribute__((swift_name("doCopy(eventName:eventDescription:eventLocation:participants:msFromNow:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *eventDescription __attribute__((swift_name("eventDescription")));
@property (readonly) NSString *eventLocation __attribute__((swift_name("eventLocation")));
@property (readonly) NSString *eventName __attribute__((swift_name("eventName")));
@property (readonly) int64_t msFromNow __attribute__((swift_name("msFromNow")));
@property (readonly) NSArray<SharedEventParticipants *> * _Nullable participants __attribute__((swift_name("participants")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EventParticipants")))
@interface SharedEventParticipants : SharedBase
- (instancetype)initWithEmailAddress:(NSString *)emailAddress firstName:(NSString *)firstName lastName:(NSString *)lastName mobileNumber:(NSString *)mobileNumber __attribute__((swift_name("init(emailAddress:firstName:lastName:mobileNumber:)"))) __attribute__((objc_designated_initializer));
- (SharedEventParticipants *)doCopyEmailAddress:(NSString *)emailAddress firstName:(NSString *)firstName lastName:(NSString *)lastName mobileNumber:(NSString *)mobileNumber __attribute__((swift_name("doCopy(emailAddress:firstName:lastName:mobileNumber:)")));
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
@interface SharedKmpCamera : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpCameraCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpCamera.Companion")))
@interface SharedKmpCameraCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpCameraCompanion *shared __attribute__((swift_name("shared")));
- (void)capturePhotoActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("capturePhoto(actionResult:)")));
- (void)captureVideoActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("captureVideo(actionResult:)")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpClipboard")))
@interface SharedKmpClipboard : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpClipboardCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpClipboard.Companion")))
@interface SharedKmpClipboardCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpClipboardCompanion *shared __attribute__((swift_name("shared")));
- (void)doCopyTextIntoClipboardTextToCopy:(NSString *)textToCopy __attribute__((swift_name("doCopyTextIntoClipboard(textToCopy:)")));
- (NSString *)getTextFromClipboard __attribute__((swift_name("getTextFromClipboard()")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpConnectivity")))
@interface SharedKmpConnectivity : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpConnectivityCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpConnectivity.Companion")))
@interface SharedKmpConnectivityCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpConnectivityCompanion *shared __attribute__((swift_name("shared")));

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
- (void)listenToConnectionChangeConnectionState:(void (^)(SharedBoolean *))connectionState completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("listenToConnectionChange(connectionState:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Contact")))
@interface SharedContact : SharedBase
- (instancetype)initWithId:(NSString *)id namePrefix:(NSString *)namePrefix givenName:(NSString *)givenName middleName:(NSString *)middleName familyName:(NSString *)familyName nameSuffix:(NSString *)nameSuffix phoneNumbers:(NSArray<NSString *> *)phoneNumbers emails:(NSArray<NSString *> *)emails displayName:(NSString *)displayName __attribute__((swift_name("init(id:namePrefix:givenName:middleName:familyName:nameSuffix:phoneNumbers:emails:displayName:)"))) __attribute__((objc_designated_initializer));
- (SharedContact *)doCopyId:(NSString *)id namePrefix:(NSString *)namePrefix givenName:(NSString *)givenName middleName:(NSString *)middleName familyName:(NSString *)familyName nameSuffix:(NSString *)nameSuffix phoneNumbers:(NSArray<NSString *> *)phoneNumbers emails:(NSArray<NSString *> *)emails displayName:(NSString *)displayName __attribute__((swift_name("doCopy(id:namePrefix:givenName:middleName:familyName:nameSuffix:phoneNumbers:emails:displayName:)")));
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
@interface SharedKmpContacts : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpContactsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpContacts.Companion")))
@interface SharedKmpContactsCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpContactsCompanion *shared __attribute__((swift_name("shared")));
- (void)getAllContactsContactsResponse:(void (^)(NSArray<SharedContact *> * _Nullable))contactsResponse __attribute__((swift_name("getAllContacts(contactsResponse:)")));
- (void)pickContactContactsResponse:(void (^)(SharedContact * _Nullable))contactsResponse __attribute__((swift_name("pickContact(contactsResponse:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceDisplay")))
@interface SharedKmpDeviceDisplay : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpDeviceDisplayCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceDisplay.Companion")))
@interface SharedKmpDeviceDisplayCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpDeviceDisplayCompanion *shared __attribute__((swift_name("shared")));
- (void)adjustScreenBrightnessBrightness:(double)brightness __attribute__((swift_name("adjustScreenBrightness(brightness:)")));
- (void)disableScreenOnActive __attribute__((swift_name("disableScreenOnActive()")));
- (void)keepScreenOnActive __attribute__((swift_name("keepScreenOnActive()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DevicePlatform")))
@interface SharedDevicePlatform : SharedKotlinEnum<SharedDevicePlatform *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedDevicePlatform *ios __attribute__((swift_name("ios")));
@property (class, readonly) SharedDevicePlatform *android __attribute__((swift_name("android")));
@property (class, readonly) SharedDevicePlatform *windows __attribute__((swift_name("windows")));
@property (class, readonly) SharedDevicePlatform *macos __attribute__((swift_name("macos")));
@property (class, readonly) SharedDevicePlatform *linux __attribute__((swift_name("linux")));
@property (class, readonly) SharedDevicePlatform *tizen __attribute__((swift_name("tizen")));
@property (class, readonly) SharedDevicePlatform *applewatch __attribute__((swift_name("applewatch")));
@property (class, readonly) SharedDevicePlatform *unknown __attribute__((swift_name("unknown")));
+ (SharedKotlinArray<SharedDevicePlatform *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedDevicePlatform *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DeviceSpecs")))
@interface SharedDeviceSpecs : SharedBase
- (instancetype)initWithDeviceModel:(NSString *)deviceModel systemVersion:(NSString *)systemVersion manufacturer:(NSString *)manufacturer __attribute__((swift_name("init(deviceModel:systemVersion:manufacturer:)"))) __attribute__((objc_designated_initializer));
- (SharedDeviceSpecs *)doCopyDeviceModel:(NSString *)deviceModel systemVersion:(NSString *)systemVersion manufacturer:(NSString *)manufacturer __attribute__((swift_name("doCopy(deviceModel:systemVersion:manufacturer:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *deviceModel __attribute__((swift_name("deviceModel")));
@property (readonly) NSString *manufacturer __attribute__((swift_name("manufacturer")));
@property (readonly) NSString *systemVersion __attribute__((swift_name("systemVersion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DeviceType")))
@interface SharedDeviceType : SharedKotlinEnum<SharedDeviceType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedDeviceType *virtual_ __attribute__((swift_name("virtual_")));
@property (class, readonly) SharedDeviceType *physical __attribute__((swift_name("physical")));
@property (class, readonly) SharedDeviceType *unknown __attribute__((swift_name("unknown")));
+ (SharedKotlinArray<SharedDeviceType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedDeviceType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceInfo")))
@interface SharedKmpDeviceInfo : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpDeviceInfoCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpDeviceInfo.Companion")))
@interface SharedKmpDeviceInfoCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpDeviceInfoCompanion *shared __attribute__((swift_name("shared")));
- (SharedDeviceSpecs *)getDeviceSpecs __attribute__((swift_name("getDeviceSpecs()")));
- (NSString *)getDeviceTimeZone __attribute__((swift_name("getDeviceTimeZone()")));
- (SharedDevicePlatform *)getRunningPlatform __attribute__((swift_name("getRunningPlatform()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpEmail")))
@interface SharedKmpEmail : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpEmailCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpEmail.Companion")))
@interface SharedKmpEmailCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpEmailCompanion *shared __attribute__((swift_name("shared")));
- (void)isEmailSupportedAction:(void (^)(SharedBoolean *))action __attribute__((swift_name("isEmailSupported(action:)")));
- (void)sendEmailToAddressAddress:(NSString *)address emailSubject:(NSString *)emailSubject emailMessage:(NSString *)emailMessage __attribute__((swift_name("sendEmailToAddress(address:emailSubject:emailMessage:)")));
- (void)sendEmailsToCCAddressAddress:(NSString *)address ccAddresses:(SharedKotlinArray<NSString *> * _Nullable)ccAddresses emailSubject:(NSString *)emailSubject emailMessage:(NSString *)emailMessage __attribute__((swift_name("sendEmailsToCCAddress(address:ccAddresses:emailSubject:emailMessage:)")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("EmailReceipientDelegate")))
@interface SharedEmailReceipientDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("File")))
@interface SharedFile : SharedBase
- (instancetype)initWithName:(NSString *)name absolutePath:(NSString *)absolutePath isProtected:(BOOL)isProtected modifiedISO:(NSString *)modifiedISO createdISO:(NSString *)createdISO __attribute__((swift_name("init(name:absolutePath:isProtected:modifiedISO:createdISO:)"))) __attribute__((objc_designated_initializer));
- (SharedFile *)doCopyName:(NSString *)name absolutePath:(NSString *)absolutePath isProtected:(BOOL)isProtected modifiedISO:(NSString *)modifiedISO createdISO:(NSString *)createdISO __attribute__((swift_name("doCopy(name:absolutePath:isProtected:modifiedISO:createdISO:)")));
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
@interface SharedKmpFilePicker : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpFilePickerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFilePicker.Companion")))
@interface SharedKmpFilePickerCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpFilePickerCompanion *shared __attribute__((swift_name("shared")));
- (void)getFileFromPickerAction:(void (^)(SharedFile * _Nullable))action __attribute__((swift_name("getFileFromPicker(action:)")));
- (void)getMultipleFilesFromPickerActions:(void (^)(NSArray<SharedFile *> * _Nullable))actions __attribute__((swift_name("getMultipleFilesFromPicker(actions:)")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("DocumentManyPickerDelegate")))
@interface SharedDocumentManyPickerDelegate : NSObject
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("DocumentPickerDelegate")))
@interface SharedDocumentPickerDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFileSystem")))
@interface SharedKmpFileSystem : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpFileSystemCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFileSystem.Companion")))
@interface SharedKmpFileSystemCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpFileSystemCompanion *shared __attribute__((swift_name("shared")));
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
@interface SharedFlashLightMode : SharedKotlinEnum<SharedFlashLightMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedFlashLightMode *low __attribute__((swift_name("low")));
@property (class, readonly) SharedFlashLightMode *medium __attribute__((swift_name("medium")));
@property (class, readonly) SharedFlashLightMode *high __attribute__((swift_name("high")));
@property (class, readonly) SharedFlashLightMode *max __attribute__((swift_name("max")));
@property (class, readonly) SharedFlashLightMode *default_ __attribute__((swift_name("default_")));
+ (SharedKotlinArray<SharedFlashLightMode *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedFlashLightMode *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFlashlight")))
@interface SharedKmpFlashlight : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpFlashlightCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpFlashlight.Companion")))
@interface SharedKmpFlashlightCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpFlashlightCompanion *shared __attribute__((swift_name("shared")));
- (void)turnOffFlashlight __attribute__((swift_name("turnOffFlashlight()")));
- (void)turnOnFlashLightWithAdjustableStrengthStrengthLevel:(SharedFlashLightMode *)strengthLevel __attribute__((swift_name("turnOnFlashLightWithAdjustableStrength(strengthLevel:)")));
- (void)turnOnFlashlight __attribute__((swift_name("turnOnFlashlight()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGeolocation")))
@interface SharedKmpGeolocation : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpGeolocationCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGeolocation.Companion")))
@interface SharedKmpGeolocationCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpGeolocationCompanion *shared __attribute__((swift_name("shared")));
- (void)getCurrentLocationLocationCoord:(void (^)(SharedLocation *))locationCoord __attribute__((swift_name("getCurrentLocation(locationCoord:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Location")))
@interface SharedLocation : SharedBase
- (instancetype)initWithLatitude:(double)latitude longitude:(double)longitude __attribute__((swift_name("init(latitude:longitude:)"))) __attribute__((objc_designated_initializer));
- (SharedLocation *)doCopyLatitude:(double)latitude longitude:(double)longitude __attribute__((swift_name("doCopy(latitude:longitude:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) double latitude __attribute__((swift_name("latitude")));
@property (readonly) double longitude __attribute__((swift_name("longitude")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGyroscope")))
@interface SharedKmpGyroscope : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpGyroscopeCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpGyroscope.Companion")))
@interface SharedKmpGyroscopeCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpGyroscopeCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningGyroScopeVal:(void (^)(SharedKotlinTriple<SharedFloat *, SharedFloat *, SharedFloat *> *))gyroScopeVal __attribute__((swift_name("startListening(gyroScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Mimes")))
@interface SharedMimes : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)mimes __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedMimes *shared __attribute__((swift_name("shared")));
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
@interface SharedKmpLauncher : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpLauncherCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLauncher.Companion")))
@interface SharedKmpLauncherCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpLauncherCompanion *shared __attribute__((swift_name("shared")));
- (void)launchAppInternalSettings __attribute__((swift_name("launchAppInternalSettings()")));
- (void)launchAppStoreViaIdentifierAppStoreLink:(NSString *)appStoreLink __attribute__((swift_name("launchAppStoreViaIdentifier(appStoreLink:)")));
- (void)launchExternalMapsAppWithAddressAddress:(NSString *)address markerTitle:(NSString *)markerTitle __attribute__((swift_name("launchExternalMapsAppWithAddress(address:markerTitle:)")));
- (void)launchExternalMapsAppWithCoordinatesLatitude:(double)latitude longitude:(double)longitude markerTitle:(NSString *)markerTitle __attribute__((swift_name("launchExternalMapsAppWithCoordinates(latitude:longitude:markerTitle:)")));
- (void)launchExternalUrlViaAnyAppLinkPath:(NSString *)linkPath __attribute__((swift_name("launchExternalUrlViaAnyApp(linkPath:)")));
- (void)launchExternalUrlViaBrowserLinkPath:(NSString *)linkPath __attribute__((swift_name("launchExternalUrlViaBrowser(linkPath:)")));
- (void)startTimerSeconds:(double)seconds action:(SharedBoolean *(^)(void))action __attribute__((swift_name("startTimer(seconds:action:)")));
- (void)startTimerRepeatingSeconds:(double)seconds action:(SharedBoolean *(^)(void))action __attribute__((swift_name("startTimerRepeating(seconds:action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLifecycle")))
@interface SharedKmpLifecycle : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpLifecycleCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLifecycle.Companion")))
@interface SharedKmpLifecycleCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpLifecycleCompanion *shared __attribute__((swift_name("shared")));
- (void)resetAppLifecycleActions __attribute__((swift_name("resetAppLifecycleActions()")));
- (void)setAppLifecycleBackgroundAction:(void (^)(void))action __attribute__((swift_name("setAppLifecycleBackground(action:)")));
- (void)setAppLifecycleForegroundAction:(void (^)(void))action __attribute__((swift_name("setAppLifecycleForeground(action:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)waitForAppToReturnToForegroundAction:(id<SharedKotlinSuspendFunction0>)action completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("waitForAppToReturnToForeground(action:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLocalNotifications")))
@interface SharedKmpLocalNotifications : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpLocalNotificationsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLocalNotifications.Companion")))
@interface SharedKmpLocalNotificationsCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpLocalNotificationsCompanion *shared __attribute__((swift_name("shared")));
- (void)cancelAlarmWithIdAlarmId:(NSString *)alarmId __attribute__((swift_name("cancelAlarmWithId(alarmId:)")));
- (void)cancelAllAlarms __attribute__((swift_name("cancelAllAlarms()")));
- (BOOL)isSchedulingAlarmWithIdAlarmId:(NSString *)alarmId __attribute__((swift_name("isSchedulingAlarmWithId(alarmId:)")));
- (NSString *)scheduleAlarmNotificationDurationMS:(int64_t)durationMS title:(NSString *)title message:(NSString *)message __attribute__((swift_name("scheduleAlarmNotification(durationMS:title:message:)")));
- (NSString *)scheduleAlarmNotificationRepeatingDurationMS:(int64_t)durationMS intervalMs:(int64_t)intervalMs title:(NSString *)title message:(NSString *)message __attribute__((swift_name("scheduleAlarmNotificationRepeating(durationMS:intervalMs:title:message:)")));
- (void)sendNotificationTitle:(NSString *)title message:(NSString *)message __attribute__((swift_name("sendNotification(title:message:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLogging")))
@interface SharedKmpLogging : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpLoggingCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpLogging.Companion")))
@interface SharedKmpLoggingCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpLoggingCompanion *shared __attribute__((swift_name("shared")));
- (void)writeErrorTag:(NSString *)tag message:(NSString *)message __attribute__((swift_name("writeError(tag:message:)")));
- (void)writeErrorWithCodeErrorCode:(NSString *)errorCode __attribute__((swift_name("writeErrorWithCode(errorCode:)")));
- (void)writeExceptionTag:(NSString *)tag exception:(SharedKotlinException *)exception __attribute__((swift_name("writeException(tag:exception:)")));
- (void)writeInfoTag:(NSString *)tag message:(NSString *)message __attribute__((swift_name("writeInfo(tag:message:)")));
- (void)writeInfoWithCodeErrorCode:(NSString *)errorCode __attribute__((swift_name("writeInfoWithCode(errorCode:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMagnometer")))
@interface SharedKmpMagnometer : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpMagnometerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMagnometer.Companion")))
@interface SharedKmpMagnometerCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpMagnometerCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningMagScopeVal:(void (^)(SharedKotlinTriple<SharedFloat *, SharedFloat *, SharedFloat *> *))magScopeVal __attribute__((swift_name("startListening(magScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMainThread")))
@interface SharedKmpMainThread : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpMainThreadCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMainThread.Companion")))
@interface SharedKmpMainThreadCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpMainThreadCompanion *shared __attribute__((swift_name("shared")));
- (void)runViaMainThreadAction:(void (^)(void))action __attribute__((swift_name("runViaMainThread(action:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMediaPicker")))
@interface SharedKmpMediaPicker : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpMediaPickerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpMediaPicker.Companion")))
@interface SharedKmpMediaPickerCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpMediaPickerCompanion *shared __attribute__((swift_name("shared")));
- (void)pickPhotoFromGalleryActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("pickPhotoFromGallery(actionResult:)")));
- (void)pickVideoFromGalleryActionResult:(void (^)(NSString *))actionResult __attribute__((swift_name("pickVideoFromGallery(actionResult:)")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("ImageMediaPickerDelegate")))
@interface SharedImageMediaPickerDelegate : NSObject
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("MediaPickerDelegate")))
@interface SharedMediaPickerDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpOrientationManager")))
@interface SharedKmpOrientationManager : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpOrientationManagerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpOrientationManager.Companion")))
@interface SharedKmpOrientationManagerCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpOrientationManagerCompanion *shared __attribute__((swift_name("shared")));
- (SharedOrientationState *)getCurrentOrientation __attribute__((swift_name("getCurrentOrientation()")));
- (void)startListeningOrientationChange:(void (^)(SharedOrientationState *))orientationChange __attribute__((swift_name("startListening(orientationChange:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("OrientationState")))
@interface SharedOrientationState : SharedKotlinEnum<SharedOrientationState *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedOrientationState *landscape __attribute__((swift_name("landscape")));
@property (class, readonly) SharedOrientationState *portrait __attribute__((swift_name("portrait")));
@property (class, readonly) SharedOrientationState *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) SharedOrientationState *leftwrist __attribute__((swift_name("leftwrist")));
@property (class, readonly) SharedOrientationState *rightwrist __attribute__((swift_name("rightwrist")));
+ (SharedKotlinArray<SharedOrientationState *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedOrientationState *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPermissionsManager")))
@interface SharedKmpPermissionsManager : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpPermissionsManagerCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPermissionsManager.Companion")))
@interface SharedKmpPermissionsManagerCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpPermissionsManagerCompanion *shared __attribute__((swift_name("shared")));
- (void)canShowPromptDialogPermission:(SharedPermission *)permission actionResult:(void (^)(SharedBoolean *))actionResult __attribute__((swift_name("canShowPromptDialog(permission:actionResult:)")));
- (BOOL)isPermissionGrantedPermission:(SharedPermission *)permission __attribute__((swift_name("isPermissionGranted(permission:)")));
- (void)isPermissionGrantedPermission:(SharedPermission *)permission actionResult:(void (^)(SharedBoolean *))actionResult __attribute__((swift_name("isPermissionGranted(permission:actionResult:)")));
- (void)requestPermissionPermission:(SharedPermission *)permission runAction:(void (^)(void))runAction __attribute__((swift_name("requestPermission(permission:runAction:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Permission")))
@interface SharedPermission : SharedKotlinEnum<SharedPermission *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedPermission *camera __attribute__((swift_name("camera")));
@property (class, readonly) SharedPermission *flashlight __attribute__((swift_name("flashlight")));
@property (class, readonly) SharedPermission *externalstorage __attribute__((swift_name("externalstorage")));
@property (class, readonly) SharedPermission *location __attribute__((swift_name("location")));
@property (class, readonly) SharedPermission *photogallery __attribute__((swift_name("photogallery")));
@property (class, readonly) SharedPermission *speech __attribute__((swift_name("speech")));
@property (class, readonly) SharedPermission *coarselocation __attribute__((swift_name("coarselocation")));
@property (class, readonly) SharedPermission *sms __attribute__((swift_name("sms")));
@property (class, readonly) SharedPermission *microphone __attribute__((swift_name("microphone")));
@property (class, readonly) SharedPermission *pushnotifications __attribute__((swift_name("pushnotifications")));
@property (class, readonly) SharedPermission *biometrics __attribute__((swift_name("biometrics")));
@property (class, readonly) SharedPermission *contacts __attribute__((swift_name("contacts")));
@property (class, readonly) SharedPermission *vibrator __attribute__((swift_name("vibrator")));
@property (class, readonly) SharedPermission *calendar __attribute__((swift_name("calendar")));
+ (SharedKotlinArray<SharedPermission *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedPermission *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("PermissionStatus")))
@interface SharedPermissionStatus : SharedKotlinEnum<SharedPermissionStatus *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) SharedPermissionStatus *granted __attribute__((swift_name("granted")));
@property (class, readonly) SharedPermissionStatus *denied __attribute__((swift_name("denied")));
@property (class, readonly) SharedPermissionStatus *idle __attribute__((swift_name("idle")));
+ (SharedKotlinArray<SharedPermissionStatus *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<SharedPermissionStatus *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((unavailable("Kotlin subclass of Objective-C class can't be imported")))
__attribute__((swift_name("LocationPermissionsDelegate")))
@interface SharedLocationPermissionsDelegate : NSObject
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPrinting")))
@interface SharedKmpPrinting : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpPrintingCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPrinting.Companion")))
@interface SharedKmpPrintingCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpPrintingCompanion *shared __attribute__((swift_name("shared")));
- (BOOL)isPrintingSupported __attribute__((swift_name("isPrintingSupported()")));
- (void)printDocumentWithPathPath:(NSString *)path __attribute__((swift_name("printDocumentWithPath(path:)")));
- (void)printHtmlWithPathPath:(NSString *)path __attribute__((swift_name("printHtmlWithPath(path:)")));
- (void)printImageWithPathPath:(NSString *)path __attribute__((swift_name("printImageWithPath(path:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpProximity")))
@interface SharedKmpProximity : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpProximityCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpProximity.Companion")))
@interface SharedKmpProximityCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpProximityCompanion *shared __attribute__((swift_name("shared")));
- (void)startListeningProximityScopeVal:(void (^)(SharedBoolean *))proximityScopeVal __attribute__((swift_name("startListening(proximityScopeVal:)")));
- (void)stopListening __attribute__((swift_name("stopListening()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPromptReview")))
@interface SharedKmpPromptReview : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpPromptReviewCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPromptReview.Companion")))
@interface SharedKmpPromptReviewCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpPromptReviewCompanion *shared __attribute__((swift_name("shared")));
- (void)openAppStoreLink __attribute__((swift_name("openAppStoreLink()")));
- (void)promptReviewInAppErrorPromptingDialog:(void (^)(NSString *))errorPromptingDialog actionAfterClosing:(void (^ _Nullable)(void))actionAfterClosing __attribute__((swift_name("promptReviewInApp(errorPromptingDialog:actionAfterClosing:)")));
- (void)promptReviewViaExternal __attribute__((swift_name("promptReviewViaExternal()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpScreenshot")))
@interface SharedKmpScreenshot : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpScreenshotCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpScreenshot.Companion")))
@interface SharedKmpScreenshotCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpScreenshotCompanion *shared __attribute__((swift_name("shared")));
- (void)getScreenshotAction:(void (^)(NSString *))action shareDialogTitle:(NSString *)shareDialogTitle shareImage:(BOOL)shareImage __attribute__((swift_name("getScreenshot(action:shareDialogTitle:shareImage:)")));
- (BOOL)isSupported __attribute__((swift_name("isSupported()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPublicStorage")))
@interface SharedKmpPublicStorage : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpPublicStorageCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpPublicStorage.Companion")))
@interface SharedKmpPublicStorageCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpPublicStorageCompanion *shared __attribute__((swift_name("shared")));
- (void)clearEntireStore __attribute__((swift_name("clearEntireStore()")));
- (void)deleteDataForKeyKey:(NSString *)key __attribute__((swift_name("deleteDataForKey(key:)")));
- (SharedBoolean * _Nullable)getBooleanFromKeyKey:(NSString *)key __attribute__((swift_name("getBooleanFromKey(key:)")));
- (BOOL)getBooleanFromKeyKey:(NSString *)key defValue:(BOOL)defValue __attribute__((swift_name("getBooleanFromKey(key:defValue:)")));
- (SharedDouble * _Nullable)getDoubleFromKeyKey:(NSString *)key __attribute__((swift_name("getDoubleFromKey(key:)")));
- (double)getDoubleFromKeyKey:(NSString *)key defValue:(double)defValue __attribute__((swift_name("getDoubleFromKey(key:defValue:)")));
- (SharedFloat * _Nullable)getFloatFromKeyKey:(NSString *)key __attribute__((swift_name("getFloatFromKey(key:)")));
- (float)getFloatFromKeyKey:(NSString *)key defValue:(float)defValue __attribute__((swift_name("getFloatFromKey(key:defValue:)")));
- (SharedInt * _Nullable)getIntFromKeyKey:(NSString *)key __attribute__((swift_name("getIntFromKey(key:)")));
- (int32_t)getIntFromKeyKey:(NSString *)key defValue:(int32_t)defValue __attribute__((swift_name("getIntFromKey(key:defValue:)")));
- (SharedLong * _Nullable)getLongFromKeyKey:(NSString *)key __attribute__((swift_name("getLongFromKey(key:)")));
- (int64_t)getLongFromKeyKey:(NSString *)key defValue:(int64_t)defValue __attribute__((swift_name("getLongFromKey(key:defValue:)")));
- (NSString * _Nullable)getStringFromKeyKey:(NSString *)key __attribute__((swift_name("getStringFromKey(key:)")));
- (NSString * _Nullable)getStringFromKeyKey:(NSString *)key defValue:(NSString * _Nullable)defValue __attribute__((swift_name("getStringFromKey(key:defValue:)")));
- (void)persistDataKey:(NSString *)key item:(id _Nullable)item __attribute__((swift_name("persistData(key:item:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSecureStorage")))
@interface SharedKmpSecureStorage : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpSecureStorageCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSecureStorage.Companion")))
@interface SharedKmpSecureStorageCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpSecureStorageCompanion *shared __attribute__((swift_name("shared")));
- (void)clearEntireStore __attribute__((swift_name("clearEntireStore()")));
- (void)configureSecurityForiOSServiceName:(NSString *)serviceName accessGroup:(NSString *)accessGroup __attribute__((swift_name("configureSecurityForiOS(serviceName:accessGroup:)")));
- (void)deleteDataForKeyKey:(NSString *)key __attribute__((swift_name("deleteDataForKey(key:)")));
- (SharedBoolean * _Nullable)getBooleanFromKeyKey:(NSString *)key __attribute__((swift_name("getBooleanFromKey(key:)")));
- (SharedDouble * _Nullable)getDoubleFromKeyKey:(NSString *)key __attribute__((swift_name("getDoubleFromKey(key:)")));
- (SharedFloat * _Nullable)getFloatFromKeyKey:(NSString *)key __attribute__((swift_name("getFloatFromKey(key:)")));
- (SharedInt * _Nullable)getIntFromKeyKey:(NSString *)key __attribute__((swift_name("getIntFromKey(key:)")));
- (SharedLong * _Nullable)getLongFromKeyKey:(NSString *)key __attribute__((swift_name("getLongFromKey(key:)")));
- (NSString * _Nullable)getStringFromKeyKey:(NSString *)key __attribute__((swift_name("getStringFromKey(key:)")));
- (void)persistDataKey:(NSString *)key item:(id _Nullable)item __attribute__((swift_name("persistData(key:item:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpShare")))
@interface SharedKmpShare : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpShareCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpShare.Companion")))
@interface SharedKmpShareCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpShareCompanion *shared __attribute__((swift_name("shared")));
- (SharedKmpShareCompanion *)setFileTypeCFileType:(NSString *)cFileType __attribute__((swift_name("setFileType(cFileType:)")));
- (void)shareFileWithAnyAppFilePath:(NSString *)filePath optionalTitle:(NSString *)optionalTitle __attribute__((swift_name("shareFileWithAnyApp(filePath:optionalTitle:)")));
- (void)shareTextWithAnyAppText:(NSString *)text optionalTitle:(NSString *)optionalTitle __attribute__((swift_name("shareTextWithAnyApp(text:optionalTitle:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSms")))
@interface SharedKmpSms : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpSmsCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpSms.Companion")))
@interface SharedKmpSmsCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpSmsCompanion *shared __attribute__((swift_name("shared")));
- (void)sendSmsToNumberMessage:(NSString *)message mobileNumber:(NSString *)mobileNumber __attribute__((swift_name("sendSmsToNumber(message:mobileNumber:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTelecom")))
@interface SharedKmpTelecom : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpTelecomCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTelecom.Companion")))
@interface SharedKmpTelecomCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpTelecomCompanion *shared __attribute__((swift_name("shared")));
- (void)launchPhoneCallWithNumberMobileNumber:(NSString *)mobileNumber __attribute__((swift_name("launchPhoneCallWithNumber(mobileNumber:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTextToSpeech")))
@interface SharedKmpTextToSpeech : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpTextToSpeechCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpTextToSpeech.Companion")))
@interface SharedKmpTextToSpeechCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpTextToSpeechCompanion *shared __attribute__((swift_name("shared")));
- (void)convertSpeechToTextResponse:(void (^)(NSString *))response __attribute__((swift_name("convertSpeechToText(response:)")));
- (void)convertTextToSpeechMessage:(NSString *)message __attribute__((swift_name("convertTextToSpeech(message:)")));
- (void)stopSpeechEngine __attribute__((swift_name("stopSpeechEngine()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpToast")))
@interface SharedKmpToast : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpToastCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpToast.Companion")))
@interface SharedKmpToastCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpToastCompanion *shared __attribute__((swift_name("shared")));
- (void)showToastLongMessage:(NSString *)message __attribute__((swift_name("showToastLong(message:)")));
- (void)showToastShortMessage:(NSString *)message __attribute__((swift_name("showToastShort(message:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpVibration")))
@interface SharedKmpVibration : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) SharedKmpVibrationCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KmpVibration.Companion")))
@interface SharedKmpVibrationCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKmpVibrationCompanion *shared __attribute__((swift_name("shared")));
- (void)startVibratingDurationMs:(int64_t)durationMs __attribute__((swift_name("startVibrating(durationMs:)")));
- (void)stopVibrating __attribute__((swift_name("stopVibrating()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinTriple")))
@interface SharedKotlinTriple<__covariant A, __covariant B, __covariant C> : SharedBase
- (instancetype)initWithFirst:(A _Nullable)first second:(B _Nullable)second third:(C _Nullable)third __attribute__((swift_name("init(first:second:third:)"))) __attribute__((objc_designated_initializer));
- (SharedKotlinTriple<A, B, C> *)doCopyFirst:(A _Nullable)first second:(B _Nullable)second third:(C _Nullable)third __attribute__((swift_name("doCopy(first:second:third:)")));
- (BOOL)equalsOther:(id _Nullable)other __attribute__((swift_name("equals(other:)")));
- (int32_t)hashCode __attribute__((swift_name("hashCode()")));
- (NSString *)toString __attribute__((swift_name("toString()")));
@property (readonly) A _Nullable first __attribute__((swift_name("first")));
@property (readonly) B _Nullable second __attribute__((swift_name("second")));
@property (readonly) C _Nullable third __attribute__((swift_name("third")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface SharedKotlinEnumCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface SharedKotlinArray<T> : SharedBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(SharedInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<SharedKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("KotlinFunction")))
@protocol SharedKotlinFunction
@required
@end

__attribute__((swift_name("KotlinSuspendFunction0")))
@protocol SharedKotlinSuspendFunction0 <SharedKotlinFunction>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeWithCompletionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(completionHandler:)")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface SharedKotlinThrowable : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (SharedKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface SharedKotlinException : SharedKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface SharedKotlinRuntimeException : SharedKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface SharedKotlinIllegalStateException : SharedKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface SharedKotlinCancellationException : SharedKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol SharedKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
